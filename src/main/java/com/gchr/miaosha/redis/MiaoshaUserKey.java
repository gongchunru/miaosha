package com.gchr.miaosha.redis;

/**
 * @author gongchunru
 * @email gongchunru@gmail.com
 * Date：2018/1/10 19:57
 */
public class MiaoshaUserKey extends BasePrefix {

    public static final int TOKEN_EXPIRE = 3600*24 * 2;

    public MiaoshaUserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static MiaoshaUserKey token = new MiaoshaUserKey(TOKEN_EXPIRE, "tk");
    //对象缓存 ，永久有效
    public static MiaoshaUserKey getById = new MiaoshaUserKey(0, "id");

}
