package com.horse.common.util;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateUtilTest {
    @Test
    public void testStringToYYYYMMddHHMMSS(){
        Date date = DateUtil.stringToYYYYMMDDHHMMSS("2013-07-11 17:36:36");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        
        assertThat("年", calendar.get(Calendar.YEAR), equalTo(2013));
        //取月份要加1
        assertThat("月", calendar.get(Calendar.MONTH)+1, equalTo(7));
        assertThat("日", calendar.get(Calendar.DAY_OF_MONTH), equalTo(11));
        assertThat("时", calendar.get(Calendar.HOUR_OF_DAY), equalTo(17));
        assertThat("分", calendar.get(Calendar.MINUTE), equalTo(36));
        assertThat("秒", calendar.get(Calendar.SECOND), equalTo(36));
    }
    
    
    @Test
    public void testStringToYYYYMMdd(){
        Date date = DateUtil.stringToYYYYMMDD("2013-07-11");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        
        assertThat("年", calendar.get(Calendar.YEAR), equalTo(2013));
        //取月份要加1
        assertThat("月", calendar.get(Calendar.MONTH)+1, equalTo(7));
        assertThat("日", calendar.get(Calendar.DAY_OF_MONTH), equalTo(11));
        assertThat("时", calendar.get(Calendar.HOUR_OF_DAY), equalTo(0));
        assertThat("分", calendar.get(Calendar.MINUTE), equalTo(0));
        assertThat("秒", calendar.get(Calendar.SECOND), equalTo(0));
    }
    
    
}
