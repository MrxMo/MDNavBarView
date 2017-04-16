package com.mrmo.mnavbarviewlib.util;

/**
 * 字符串工具类
 * Created by moguangjian on 15/5/28.
 */
public class StringUtil {

    private StringUtil() {

    }

    /**
     * 判断字符串或长度是否为空（空白也算为空）
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(CharSequence str) {
        if (isObjectNull(str) || str.toString().trim().length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断对象是否为空
     *
     * @param object
     * @return
     */
    public static boolean isObjectNull(Object object) {
        if (object == null) {
            return true;
        } else {
            return false;
        }
    }
}
