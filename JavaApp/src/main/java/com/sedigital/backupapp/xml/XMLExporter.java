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
 * Clase que exporta listas de objetos a archivos XML.
 */
public class XMLExporter {

    /**
     * Exporta una lista de objetos a un archivo XML.
     * @param tableName nombre de la tabla/elemento raíz.
     * @param data lista de objetos de cualquier tipo.
     * @param path ruta del archivo XML de salida.
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

                for (Field field : obj.getClass().getDeclaredFields()) {
                    field.setAccessible(true);
                    String name = field.getName();
                    Object value = field.get(obj);

                    Element fieldElement = doc.createElement(name);
                    fieldElement.setTextContent(value != null ? value.toString() : "");
                    item.appendChild(fieldElement);
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
