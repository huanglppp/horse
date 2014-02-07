package com.horse.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串常用工具类。提供了，对象转化字符串，判断字符串是否为空，日期转化为字符串功能
 * 
 * @author longhuang
 * @version 1.0,2013-07-11
 * 
 */
public class StringUtil {

    /**
     * 年月日 时分秒。2013-07-11 15:12:20。
     */
    private static final String YYYYMMDDHHMMSS_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 年月日。2013-07-11
     */
    private static final String YYYYMMDD_FORMAT = "yyyy-MM-dd";

    /**
     * 时分秒。15:12:20
     */
    private static final String HHMMSS_FORMAT = "HH:mm:ss";

    /**
     * 对象转化字符串。
     * 
     * @param obj
     *            对象
     * @return 字符串
     */
    public static final String objectToString(Object obj) {
        if (obj == null) {
            return "";
        } else {
            return obj.toString();
        }
    }

    /**
     * 判断字符串是否为空。
     * 
     * @param str
     *            字符串
     * @return 如果为空和null返回true,否则返回false
     */
    public static final boolean isNullOrBlank(String str) {
        if (null == str || "".equals(str.trim())) {
            return true;
        }
        return false;
    }

    /**
     * 把日期格式化为"yyyy-MM-dd HH:mm:ss"。 例如"2013-07-11 15:52:52"
     * 
     * @param date
     *            日期对象
     * @return 返回日期字符串
     */
    public static final String dateToStringYYYYMMDDHHMMSS(Date date) {
        return dateToString(date, YYYYMMDDHHMMSS_FORMAT);
    }

    /**
     * 把日期格式化为"yyyy-MM-dd"。 例如"2013-07-11"
     * 
     * @param date
     *            日期对象
     * @return 返回日期字符串
     */
    public static final String dateToStringYYYYMMDD(Date date) {
        return dateToString(date, YYYYMMDD_FORMAT);
    }

    /**
     * 把日期格式化为"HH:mm:ss"。 例如"15:52:52"
     * 
     * @param date
     *            日期对象
     * @return 返回日期字符串
     */
    public static final String dateToStringHHMMSS(Date date) {
        return dateToString(date, HHMMSS_FORMAT);
    }
    
    /**
     * 根据pattern把日期格式化字符串。
     * 
     * @param date
     *            日期
     * @param pattern
     *            模式
     * @return 返回格式化后字符串
     */
    public static final String dateToString(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
}
