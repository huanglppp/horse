package com.horse.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类，提供日期字符串转化为日期功能。
 * 
 * @author longhuang
 * @version 1.0,2013-07-11
 */
public class DateUtil {
    /** 格式：年－月－日 小时：分钟：秒 */
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /** 格式：年－月－日 */
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    
    

    /**
     * 把时间字符串转换成对应的时间 YYYY-MM-dd HH:mm:ss。
     * 
     * @param dateString
     *            时间字符串
     * 
     * @return 所对应的时间
     */
    public static final Date stringToYYYYMMDDHHMMSS(String dateString) {
    	return stringToDate(dateString, DATETIME_FORMAT);
    }

    /**
     * 把时间字符串转换成其对应的时间YYYY-MM-dd HH:mm:ss。
     * 
     * @param dateString
     *            时间字符串
     * 
     * @return 所对应的时间
     */
    public static final Date stringToYYYYMMDD(String dateString) {
    	return stringToDate(dateString, DATE_FORMAT);
    }

    /**
     * 时间字符串根据格式化字符串和解析点位置生成对应的时间。
     * 
     * @param dateString
     *            时间字符串
     * 
     * @param pattern
     *            格式化字符串
     * @return 所对应的时间
     */
    public static final Date stringToDate(String dateString, String pattern) {
        if (StringUtil.isNullOrBlank(dateString)) {
            return null;
        }
        Date date = null;
        SimpleDateFormat formater = new SimpleDateFormat(pattern);
        try {
            date = formater.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
