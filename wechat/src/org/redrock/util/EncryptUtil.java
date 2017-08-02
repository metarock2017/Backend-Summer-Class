package org.redrock.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 信息摘要加密MD5 SHA-1
 * 利用Tomcat自带类库将字符转化为加密后的byte数组，在将其转化为16进制的字符串
 */
public class EncryptUtil {

    private static final char[] digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /**
     * 此类不需要实例化
     */
    private EncryptUtil() {
    }

    /**
     * 32位MD5加密，结果大写
     * @param str
     * @return
     */
    public static String MD5(String str) {
        return encode(str, "MD5");
    }

    /**
     * 32位SHA1加密，结果大写
     * @param str
     * @return
     */
    public static String sha1(String str) {
        return encode(str, "SHA-1");
    }

    private static String encode(String str, String algorithm) {
        String rs = null;
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] digest = md.digest(str.toString().getBytes("UTF-8"));
            rs = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("该加密方式不存在");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 将byte数组变为16进制对应的字符串
     * @param byteArray byte数组
     * @return 转换结果
     */
    private static String byteToStr(byte[] byteArray) {
        int len = byteArray.length;
        StringBuilder strDigest = new StringBuilder(len * 2);
        for (byte aByteArray : byteArray) {
            strDigest.append(byteToHexStr(aByteArray));
        }
        return strDigest.toString();
    }

    private static String byteToHexStr(byte mByte) {
        char[] tempArr = new char[2];
        tempArr[0] = digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = digit[mByte & 0X0F];
        return new String(tempArr);
    }
}
