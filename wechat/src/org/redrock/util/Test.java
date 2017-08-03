package org.redrock.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 解析xml
 */
public class Test {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
//        String url = "";
//        String xml = CurlUtil.getContent(url, null, "GET");
//        //把str转化为Document对象
//        StringReader reader = new StringReader(xml);
//        InputSource source = new InputSource(reader);

        File file = new File("score.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

//        Document document = builder.parse(source);
        Document document = builder.parse(file);
        Element element = document.getDocumentElement();
        NodeList list = element.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            String name = node.getNodeName();
            if (name.equals("data")) {
                NodeList items = node.getChildNodes();
                List<Map<String, String>> data = new ArrayList<>();
                for (int j = 0; j < items.getLength(); j++) {
                    Node item = items.item(j);
                    NodeList itemList = item.getChildNodes();
                    Map<String, String> attrs = new HashMap<>();
                    for (int k = 0; k < itemList.getLength(); k++) {
                        Node attr = itemList.item(k);
                        String attrName = attr.getNodeName();
                        String attrValue = attr.getTextContent();
                        attrs.put(attrName, attrValue);
                    }
                    data.add(attrs);
                }
                System.out.println(data.toString());
            }
        }
    }
}
