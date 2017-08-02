package org.redrock.servlet;

import org.redrock.util.Const;
import org.redrock.util.EncryptUtil;
import org.redrock.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

//配置路由
@WebServlet(name = "IndexServlet", value = "/")
public class IndexServlet extends HttpServlet {
    //post请求处理
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
