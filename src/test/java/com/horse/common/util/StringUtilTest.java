package com.horse.common.util;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.util.Date;

import org.junit.Test;

public class StringUtilTest {
    @Test
    public void testObjectToString() {
        assertThat("转换后字符串为空", StringUtil.objectToString(null), equalTo(""));
        assertThat("转换后字符串为21", StringUtil.objectToString(new Integer(21)), equalTo("21"));
    }
    
    
    @Test
    public void testisNullOrBlank() {
        assertThat("是否为null或是空,否", StringUtil.isNullOrBlank("a"), equalTo(false));
        assertThat("是否为null或是空,是", StringUtil.isNullOrBlank(""), equalTo(true));
        assertThat("是否为null或是空,是", StringUtil.isNullOrBlank("  "), equalTo(true));
        assertThat("是否为null或是空,是", StringUtil.isNullOrBlank(null), equalTo(true));
    }
    
    @Test
    public void testDateToStringYYYYMMDDHHMMSS() throws ParseException {
        
        assertThat("是否为null或是空,否", StringUtil.dateToStringYYYYMMDDHHMMSS(getDate()),equalTo("2008-04-14 14:22:22"));
    }
    
    @Test
    public void testDateToStringYYYYMMDD() throws ParseException {
         
        assertThat("是否为null或是空,否", StringUtil.dateToStringYYYYMMDD(getDate()),equalTo("2008-04-14"));
    }
    
    @Test
    public void testDateToStringHHMMSS() throws ParseException {
        assertThat("是否为null或是空,否", StringUtil.dateToStringHHMMSS(getDate()),equalTo("14:22:22"));
    }
    
    private Date getDate() throws ParseException{
        return DateUtil.stringToYYYYMMDDHHMMSS("2008-04-14 14:22:22"); 
    }
}
