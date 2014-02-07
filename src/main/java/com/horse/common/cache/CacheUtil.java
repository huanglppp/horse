package com.horse.common.cache;

import java.util.Collection;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

/**
 * 缓存工具类，提供添加，删除缓存功能。
 * 
 * @author longhuang
 * @version 1.0,2013-07-10
 * 
 */
public final class CacheUtil {
    

    /**
     * 清除所有指定缓存数据。
     * 
     * @param cacheName
     *            缓存名称
     */
    public static void removeAllElements(String cacheName) {
        getCache(cacheName).removeAll();
    }

    /**
     * 从指定缓存中移除数据。
     * 
     * @param cacheName
     *            缓存名称
     * @param key
     *            元素key
     * @return true-移除成功，false-未找到对应数据对象
     */
    public static final boolean removeElement(String cacheName, Object key) {
        return getCache(cacheName).remove(key);
    }

    /**
     * 向指定的缓存添加元素。
     * 
     * @param cacheName
     *            缓存名称
     * @param key
     *            元素key
     * @param value
     *            元素值
     */
    public static void addElement(String cacheName, Object key, Object value) {
        Element element = new Element(key, value);
        getCache(cacheName).put(element);
    }

    /**
     * 向指定缓存添加所有元素。
     * 
     * @param cacheName
     *            缓存名称
     * @param elements
     *            元素集合
     */
    public static void addAllElements(String cacheName, Collection<Element> elements) {
        getCache(cacheName).putAll(elements);
    }

    /**
     * 根据元素key从指定的缓存中获取元素值。
     * 
     * @param cacheName
     *            缓存名称
     * @param key
     *            元素key
     * @return 返回元素值
     */
    public static Object get(String cacheName, Object key) {
        Element element = getCache(cacheName).get(key);
        if (element == null) {
            return null;
        }
        return element.getObjectValue();
    }

    /**
     * 指定缓存持久化到磁盘。
     * 
     * @param cacheName
     *            缓存名称
     */
    public static void flush(String cacheName) {
        getCache(cacheName).flush();
    }

    /**
     * 获取指定缓存的元素个数。
     * 
     * @param cacheName
     *            缓存名称
     * @return 缓存的元素个数
     */
    public static int getSize(String cacheName) {
        return getCache(cacheName).getSize();
    }

    /**
     * 根据缓存名称获取缓存对象。
     * 
     * @param cacheName
     *            缓存名称
     * @return 缓存对象
     */
    protected static Cache getCache(String cacheName) {
        return CacheSinglton.getInstance().getCache(cacheName);
    }

}
