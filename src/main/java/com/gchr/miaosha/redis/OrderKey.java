package com.gchr.miaosha.redis;

/**
 * @author gongchunru
 * @email gongchunru@gmail.com
 * Date：2018/1/10 20:05
 */
public class OrderKey extends BasePrefix {

    public OrderKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
}
