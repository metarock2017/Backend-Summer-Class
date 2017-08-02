package org.redrock.util;

import java.io.*;
import java.net.*;
import java.util.Map;

/**
 * 用于curl调用接口，传递参数与获取结果采用输入输出流
 */
public class CurlUtil {

    private static final int DEF_CONN_TIMEOUT = 30000;
    private static final int DEF_READ_TIMEOUT = 30000;
    private static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";


    /**
     *
     * @param strUrl 请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return
     */
    public static String getContent(String strUrl, Map<String, Object> params, String method) {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        HttpURLConnection conn = null;
        String paramStr = null;
        String result = null;
        //有请求参数的话拼接成字符串
        if (params != null && !params.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry i : params.entrySet()) {
                try {
                    sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                paramStr = sb.toString();
            }
            if (StringUtil.isBlank(method) || method.equalsIgnoreCase("GET")) {
                strUrl = strUrl + "?" + paramStr;
            }
        }
        try {
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
            conn.setReadTimeout(DEF_READ_TIMEOUT);
            conn.setRequestProperty("User-agent", userAgent);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if (!StringUtil.isBlank(method) && method.equalsIgnoreCase("POST")) {
                conn.setRequestMethod("POST");
                if (!StringUtil.isBlank(paramStr)) {
                    conn.setDoOutput(true);
                    writer = new BufferedWriter(
                            new OutputStreamWriter(
                                    conn.getOutputStream(), "UTF-8"
                            )
                    );
                    writer.write(paramStr);
                    writer.flush();
                }
            }
            reader = new BufferedReader(
                    new InputStreamReader(
                            conn.getInputStream(), "UTF-8"
                    )
            );
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            result = sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
                if (conn != null) conn.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}