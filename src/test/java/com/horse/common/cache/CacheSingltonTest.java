package com.horse.common.cache;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.sameInstance;
import static org.hamcrest.Matchers.equalTo;

import static org.junit.Assert.assertThat;
import net.sf.ehcache.Cache;

import org.junit.Test;

public class CacheSingltonTest {
    private static final String CACHE_NAME="test";
    
    public static final String DICT_CACHE_NAME="dictcache";
    
    @Test
    public void testGetInstance(){
        CacheSinglton cacheSinglton1 = CacheSinglton.getInstance();
        CacheSinglton cacheSinglton2 = CacheSinglton.getInstance();
        assertThat("不为空",cacheSinglton1,notNullValue());
        assertThat("单例模式两实例相同",cacheSinglton1,sameInstance(cacheSinglton2));
    }
    
    @Test
    public void testGetCacheDefaultName(){
         Cache cache = CacheSinglton.getInstance().getCache(DICT_CACHE_NAME);
         assertThat("默认缓存名称为是"+DICT_CACHE_NAME,cache.getName(),equalTo(DICT_CACHE_NAME));
    }
    
    @Test
    public void testAddAndGetCache(){
         //添加缓存
         Cache cache = new Cache(CACHE_NAME, 5000, true, true, 0, 0);
         CacheSinglton cacheSinglton = CacheSinglton.getInstance();
         cacheSinglton.addCache(cache);
         //获取缓存
         Cache newCache = cacheSinglton.getCache(CACHE_NAME);
         assertThat("不为空",newCache,notNullValue());
         assertThat("缓存对象相等",newCache,sameInstance(cache));
         assertThat("默认缓存名称为是"+CACHE_NAME,newCache.getName(),equalTo(CACHE_NAME));
    }
    
    @Test
    public void testGetCache(){
        Cache cache = CacheSinglton.getInstance().getCache("");
        assertThat("为空",cache,nullValue());
    }
}
