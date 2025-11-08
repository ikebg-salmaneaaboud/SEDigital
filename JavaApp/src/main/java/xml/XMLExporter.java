package xml;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Clase que exporta datos a archivos XML.
 */
public class XMLExporter {

    /**
     * Exporta una tabla a un archivo XML.
     * @param tableName nombre de la tabla.
     * @param data lista de filas con datos de la tabla.
     * @param path ruta del archivo XML de salida.
     */
    public void exportarTabla(String tableName, List<Map<String, Object>> data, String path) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement(tableName);
            doc.appendChild(root);

            for (Map<String, Object> row : data) {
                Element item = doc.createElement("Registro");
                for (Map.Entry<String, Object> entry : row.entrySet()) {
                    Element field = doc.createElement(entry.getKey());
                    field.setTextContent(entry.getValue() != null ? entry.getValue().toString() : "");
                    item.appendChild(field);
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
