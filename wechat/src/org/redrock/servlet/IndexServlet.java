package org.redrock.servlet;

import org.redrock.util.Const;
import org.redrock.util.EncryptUtil;
import org.redrock.util.StringUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//配置路由
@WebServlet(name = "IndexServlet", value = "/")
public class IndexServlet extends HttpServlet {
    //post请求处理
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //从request请求中获取输入流
            InputStream inputStream = request.getInputStream();
            //通过输入流获取Document对象
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = null;
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);
            //<xml>
            //  <ToUserName><![CDATA[gh_b6a171776f25]]></ToUserName>
            //  <FromUserName><![CDATA[oiL6j0WJxy7Nagpnt6rX7Yo_5LeM]]></FromUserName><CreateTime>1501741106</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[emmm]]></Content><MsgId>6449928937743195428</MsgId></xml>
            //获取根节点
            Element rootNode = document.getDocumentElement();
            //根节点名
            String name = rootNode.getNodeName();
            //获取子节点数组
            NodeList items = rootNode.getChildNodes();
            Map<String, String> result = new HashMap<>();
            //子节点遍历
            for (int i = 0; i < items.getLength(); i++) {
                Node item = items.item(i);
                String iName = item.getNodeName();
                //<ToUserName><![CDATA[gh_b6a171776f25]]></ToUserName>
                //注意：ToUserName标签内部的文本内容实际上也是一个节点，这里不能通过getNodeValue直接获取节点内容
                String value = item.getTextContent();
                if (iName.equals("#text")) {
                    continue;
                }
                result.put(iName, value);
            }
            String Content = result.get("Content");
            if (Content.equals("1")) {
                //xml格式化
                String xml = "<xml>" +
                        "<ToUserName><![CDATA[%s]]></ToUserName>" +
                        "<FromUserName><![CDATA[%s]]></FromUserName>" +
                        "<CreateTime>%s</CreateTime>" +
                        "<MsgType><![CDATA[%s]]></MsgType>" +
                        "<Content><![CDATA[%s]]></Content>" +
                        "</xml>";
                String toUser = result.get("FromUserName");
                String fromUser = result.get("ToUserName");
                String createTime = System.currentTimeMillis() / 1000 + "";
                String msgType = "text";
                String content = "hello";
                //格式化输出
                String res =String.format(xml, toUser, fromUser, createTime, msgType, content);
                //response相应输出
                response.getWriter().println(res);
            } else {

            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }


    //get请求处理
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //微信公众号管理界面配置参数
        String token = Const.Token;
        //获取请求的四个参数
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        //检验四个参数是否有效
        if (!StringUtil.hasBlank(signature, timestamp, nonce, echostr)) {
            String[] list = {token, timestamp, nonce};
            //字典排序
            Arrays.sort(list);
            //拼接字符串
            StringBuilder builder = new StringBuilder();
            for (String str : list) {
                builder.append(str);
            }
            //sha1加密
            String hashcode = EncryptUtil.sha1(builder.toString());
            //不区分大小写差异情况下比较是否相同
            if (hashcode.equalsIgnoreCase(signature)) {
                //响应输出
                response.getWriter().println(echostr);
            }
        }
    }
}
