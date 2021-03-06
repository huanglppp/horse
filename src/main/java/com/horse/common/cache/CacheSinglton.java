package com.horse.common.cache;

import java.io.IOException;
import java.io.InputStream;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

import org.springframework.core.io.ClassPathResource;

/**
 * 缓存单例模式。提供获取缓存、关闭缓存方法
 * 
 * @author longhuang
 * @version 1.0,2013-07-10
 * 
 */
public class CacheSinglton {
    private static final String EHCACHE_XML = "ehcache/ehcache.xml";

	/**
     * 缓存单例。
     */
    private static volatile CacheSinglton cacheSinglton = null;

    /**
     * 缓存管理类。
     */
    private CacheManager manager;

    /**
     * 私有构造函数，初始化CacheManager(单例模式）。
     */
    private CacheSinglton() {
    	//InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(EHCACHE_XML);
		try {
			InputStream inputStream = new ClassPathResource(EHCACHE_XML).getInputStream();
			manager = CacheManager.create(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }

    /**
     * 返回CacheSinglton唯一实例。
     * 
     * @return CacheSinglton实例
     */
    public static CacheSinglton getInstance() {
        if (cacheSinglton != null) {
            return cacheSinglton;
        }
        synchronized (CacheSinglton.class) {
            if (cacheSinglton == null) {
                cacheSinglton = new CacheSinglton();
            }
            return cacheSinglton;
        }
    }

    /**
     * 添加Cache到CacheManager。
     * 
     * @param cache
     *            缓存对象
     */
    public void addCache(Cache cache) {
        manager.addCache(cache);
    }

    /**
     * 根据缓存名称获取缓存。
     * 
     * @param cacheName
     *            缓存名称
     * @return 返回缓存对象
     */
    public Cache getCache(String cacheName) {
        return manager.getCache(cacheName);
    }

    /**
     * 
     * 卸载 CacheManager , 关闭 Cache。
     */
    public void shutdown() {
        manager.shutdown();
    }
}
