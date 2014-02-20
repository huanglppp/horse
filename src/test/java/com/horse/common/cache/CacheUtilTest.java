package com.horse.common.cache;

 
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import net.sf.ehcache.Element;

import org.junit.Test;

import static com.horse.common.constant.ConstantsTest.DICT_CACHE_NAME;
 

public class CacheUtilTest {
     
    private static final String KEY="1";
    private static final String VALUE="我第一次使用缓存";
    
    private static final String KEY1="2";
    private static final String VALUE1="我第一次使用缓存2";
    
    private static final String KEY2="3";
    private static final String VALUE2="我第一次使用缓存3";
    /**
     * 当前测试用例： 添加元素个数(3)>=maxElementsInMemory(1)+maxElementsOnDisk(2) 时候，测试会报错。
     * 所有在配置Cache时，要设置好maxElementsInMemory和maxElementsOnDisk属性。
     */
    @Test
    public void testAddAndGetAndRemoveElement(){
        //添加
        CacheUtil.addElement(DICT_CACHE_NAME,KEY, VALUE);
        CacheUtil.addElement(DICT_CACHE_NAME,KEY1, VALUE1);
       // CacheUtil.addElement(DICT_CACHE_NAME,KEY2, VALUE2);
        
        //调用flush方法，会把内存磁盘缓存数据持久化到磁盘
        CacheUtil.flush(DICT_CACHE_NAME);
        
        assertCacheSize(2);
        
        String value_key = (String)CacheUtil.get(DICT_CACHE_NAME,KEY);
        assertValue(value_key,VALUE);
        
        String value_key1 = (String)CacheUtil.get(DICT_CACHE_NAME,KEY1);
        assertValue(value_key1,VALUE1);
       
        
        //删除后
        CacheUtil.removeElement(DICT_CACHE_NAME,KEY);
        String value_key_new = (String)CacheUtil.get(DICT_CACHE_NAME,KEY);
        assertNull(value_key_new);
        
    }



    

    @Test
    public void testAddAll(){
        Element e1 = new Element(KEY, VALUE);
        Element e2 = new Element(KEY1, VALUE1);
        Element e3 = new Element(KEY2, VALUE2);
        List<Element> elements = new ArrayList<Element>();
        elements.add(e1);
        elements.add(e2);
        elements.add(e3);
        CacheUtil.addAllElements(DICT_CACHE_NAME, elements);
        
        assertCacheSize(3);
        
        String value_key = (String)CacheUtil.get(DICT_CACHE_NAME,KEY);
        assertValue(value_key,VALUE);
        
        String value_key1 = (String)CacheUtil.get(DICT_CACHE_NAME,KEY1);
        assertValue(value_key1,VALUE1);
        
        String value_key2 = (String)CacheUtil.get(DICT_CACHE_NAME,KEY2);
        assertValue(value_key2,VALUE2);
        
        //删除后
        CacheUtil.removeElement(DICT_CACHE_NAME,KEY);
        String value_key_new = (String)CacheUtil.get(DICT_CACHE_NAME,KEY);
        assertNull(value_key_new);
        
         
    }



    private void assertValue(String expected,String actual) {
        assertThat("默认缓存名称为是"+expected,expected,equalTo(actual));
    }
    
    private void assertCacheSize(int actual) {
        assertThat("默认缓存大小",CacheUtil.getSize(DICT_CACHE_NAME),equalTo(actual));
    }
    
    private void assertNull(String value_key_new) {
        assertThat("空的",value_key_new,nullValue());
    }
}
