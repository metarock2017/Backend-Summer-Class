package org.redrock.util;
public class StringUtil {

    /**
     * 检查字符串是否为空
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        return str == null || str.equals("");
    }

    /**
     * 检查是否存在空字符串
     * @param strs
     * @return
     */
    public static boolean hasBlank(String ... strs) {
        if (strs == null || strs.length == 0) {
            return true;
        } else {
            for (String str : strs) {
                if (isBlank(str)) return true;
            }
            return false;
        }
    }
}
