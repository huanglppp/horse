package com.horse.common.util;


import java.text.ParseException;
import java.util.Date;

import org.junit.Test;

import com.horse.BaseTest;

public class StringUtilTest extends BaseTest{
    @Test
    public void testObjectToString() {
        equalTo("转换后字符串为空", StringUtil.objectToString(null), "");
        equalTo("转换后字符串为21", StringUtil.objectToString(new Integer(21)), "21");
    }
    
    
    @Test
    public void testisNullOrBlank() {
        equalTo("是否为null或是空,否", StringUtil.isNullOrBlank("a"), false);
        equalTo("是否为null或是空,是", StringUtil.isNullOrBlank(""), true);
        equalTo("是否为null或是空,是", StringUtil.isNullOrBlank("  "), true);
        equalTo("是否为null或是空,是", StringUtil.isNullOrBlank(null), true);
    }
    
    @Test
    public void testDateToStringYYYYMMDDHHMMSS() throws ParseException {
        
        equalTo("是否为null或是空,否", StringUtil.dateToStringYYYYMMDDHHMMSS(getDate()),"2008-04-14 14:22:22");
    }
    
    @Test
    public void testDateToStringYYYYMMDD() throws ParseException {
         
        equalTo("是否为null或是空,否", StringUtil.dateToStringYYYYMMDD(getDate()),"2008-04-14");
    }
    
    @Test
    public void testDateToStringHHMMSS() throws ParseException {
        equalTo("是否为null或是空,否", StringUtil.dateToStringHHMMSS(getDate()),"14:22:22");
    }
    
    private Date getDate() throws ParseException{
        return DateUtil.stringToYYYYMMDDHHMMSS("2008-04-14 14:22:22"); 
    }
}
