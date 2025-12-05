package com.sedigital.backupapp.xml;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Clase que permite exportar listas de objetos a archivos XML.
 * <p>
 * Utiliza reflexión para recorrer los campos de los objetos y crear un
 * documento XML con los valores de cada campo. Cada objeto se representa
 * como un elemento "Registro" dentro del elemento raíz.
 * </p>
 */
public class XMLExporter {

    /**
     * Exporta una lista de objetos a un archivo XML.
     * <p>
     * Crea un archivo XML en la ruta indicada, con un elemento raíz
     * correspondiente al nombre de la tabla y un elemento "Registro"
     * por cada objeto de la lista. Los campos de cada objeto se agregan
     * como subelementos, y el campo "id" se establece como atributo si existe.
     * </p>
     *
     * @param tableName nombre de la tabla o elemento raíz del XML
     * @param data lista de objetos a exportar
     * @param path ruta del archivo XML de salida
     * @param <T> tipo de los objetos en la lista
     */
    public <T> void exportarTabla(String tableName, List<T> data, String path) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement(tableName);
            doc.appendChild(root);

            for (T obj : data) {
                Element item = doc.createElement("Registro");

                try {
                    Field idField = obj.getClass().getDeclaredField("id");
                    idField.setAccessible(true);
                    Object idValue = idField.get(obj);
                    if (idValue != null) {
                        item.setAttribute("id", idValue.toString());
                    }
                } catch (NoSuchFieldException ignored) {
                }

                for (Field field : obj.getClass().getDeclaredFields()) {
                    field.setAccessible(true);
                    String name = field.getName();
                    Object value = field.get(obj);

                    if ("id".equalsIgnoreCase(name)) {
                        if (value != null) item.setAttribute("id", value.toString());
                    } else {
                        Element fieldElement = doc.createElement(name);
                        fieldElement.setTextContent(value != null ? value.toString() : "");
                        item.appendChild(fieldElement);
                    }
                }

                root.appendChild(item);
            }

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            transformer.transform(new DOMSource(doc), new StreamResult(new File(path)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
