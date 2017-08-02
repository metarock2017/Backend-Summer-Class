package org.redrock.util;

import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

/**
 * xml中区分 Node Element Attribute三者区别，注意Node的种类
 */
public class XmlUtil {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        String xml = CurlUtil.getContent("http://www.w3school.com.cn/example/xmle/plant_catalog.xml", null, "GET");
        StringReader reader = new StringReader(xml);
        InputSource source = new InputSource(reader);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(source);
        //获取根节点元素
        StringBuilder stringBuilder = new StringBuilder();
        Element rootNode = document.getDocumentElement();
        readNode(rootNode, stringBuilder);
        String out = stringBuilder.toString();
        System.out.println(out);
    }
    /**
     * 递归解析xml
     * @param node
     * @param builder
     */
    public static void readNode(Node node, StringBuilder builder) {
        if (node.getNodeType() == Node.TEXT_NODE) {
            if (!node.getTextContent().trim().equals("")) {
                builder.append(node.getNodeValue());
            }
        } else {
            String nName = node.getNodeName();
            builder.append("<").append(nName);
            if (node.hasAttributes()) {
                NamedNodeMap attrs = node.getAttributes();
                for (int i = 0; i < attrs.getLength(); i++) {
                    Node attr = attrs.item(i);
                    String aName = attr.getNodeName();
                    String value = attr.getNodeValue();
                    builder.append(" ").append(aName).append("=").append(value);
                }
            }
            builder.append(">");
            if (node.hasChildNodes()) {
                NodeList childNodes = node.getChildNodes();
                for (int i = 0; i < childNodes.getLength(); i++) {
                    Node childNode = childNodes.item(i);
                    readNode(childNode, builder);
                }
            }
            builder.append("</").append(nName).append(">");
        }
    }
}
