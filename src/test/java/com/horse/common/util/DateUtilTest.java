package com.horse.common.util;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.horse.BaseTest;

public class DateUtilTest extends BaseTest{
    @Test
    public void testStringToYYYYMMddHHMMSS(){
        Date date = DateUtil.stringToYYYYMMDDHHMMSS("2013-07-11 17:36:36");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        
        equalTo("年", calendar.get(Calendar.YEAR), 2013);
        //取月份要加1
        equalTo("月", calendar.get(Calendar.MONTH)+1, 7);
        equalTo("日", calendar.get(Calendar.DAY_OF_MONTH), 11);
        equalTo("时", calendar.get(Calendar.HOUR_OF_DAY), 17);
        equalTo("分", calendar.get(Calendar.MINUTE), 36);
        equalTo("秒", calendar.get(Calendar.SECOND), 36);
    }
    
    
    @Test
    public void testStringToYYYYMMdd(){
        Date date = DateUtil.stringToYYYYMMDD("2013-07-11");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        
        equalTo("年", calendar.get(Calendar.YEAR), 2013);
        //取月份要加1
        equalTo("月", calendar.get(Calendar.MONTH)+1, 7);
        equalTo("日", calendar.get(Calendar.DAY_OF_MONTH), 11);
        equalTo("时", calendar.get(Calendar.HOUR_OF_DAY), 0);
        equalTo("分", calendar.get(Calendar.MINUTE), 0);
        equalTo("秒", calendar.get(Calendar.SECOND), 0);
    }
    
    
}
