package chao.domXml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;

/**
 * @author chao.guo
 * @Date 2020/11/4 16:42
 */
public class DOMParser {

    public static void main(String[] args) throws Exception {

        InputStream resourceAsStream = DOMParser.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(resourceAsStream);
        document.getDocumentElement().normalize();
        String rootElementName = document.getDocumentElement().getNodeName();
        System.out.println(rootElementName);
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
        Node node = (Node) xPath.evaluate("/configuration", document, XPathConstants.NODE);
        Node properties = (Node) xPath.evaluate("properties", node, XPathConstants.NODE);
        String nodeName = properties.getNodeName();
        String nodeValue = properties.getNodeValue();
        System.out.println(nodeValue);
    }
}
