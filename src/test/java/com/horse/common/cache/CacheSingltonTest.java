package com.horse.common.cache;
 
import net.sf.ehcache.Cache;

import org.junit.Test;

import com.horse.BaseTest;

import static com.horse.common.constant.ConstantsTest.DICT_CACHE_NAME;
import static com.horse.common.constant.ConstantsTest.CACHE_NAME;

public class CacheSingltonTest extends BaseTest{
    @Test
    public void testGetInstance(){
        CacheSinglton cacheSinglton1 = CacheSinglton.getInstance();
        CacheSinglton cacheSinglton2 = CacheSinglton.getInstance();
        notNullValue("不为空",cacheSinglton1);
        sameInstance("单例模式两实例相同",cacheSinglton1,cacheSinglton2);
    }
    
    @Test
    public void testGetCacheDefaultName(){
         Cache cache = CacheSinglton.getInstance().getCache(DICT_CACHE_NAME);
         equalTo("默认缓存名称为是"+DICT_CACHE_NAME,cache.getName(),DICT_CACHE_NAME);
    }
    
    @Test
    public void testAddAndGetCache(){
         //添加缓存
         Cache cache = new Cache(CACHE_NAME, 5000, true, true, 0, 0);
         CacheSinglton cacheSinglton = CacheSinglton.getInstance();
         cacheSinglton.addCache(cache);
         //获取缓存
         Cache newCache = cacheSinglton.getCache(CACHE_NAME);
         notNullValue("不为空",newCache);
         sameInstance("缓存对象相等",newCache,cache);
         equalTo("默认缓存名称为是"+CACHE_NAME,newCache.getName(),CACHE_NAME);
    }
    
    @Test
    public void testGetCache(){
        Cache cache = CacheSinglton.getInstance().getCache("");
        nullValue("为空",cache);
    }
}
