package com.gchr.miaosha.redis;

/**
 * @author gongchunru
 * @email gongchunru@gmail.com
 * Date：2018/1/10 19:53
 */
public interface KeyPrefix {

    /**
     *
     * @return
     */
    int expireSeconds();

    /**
     *
     * @return
     */
    String getPrefix();

}
