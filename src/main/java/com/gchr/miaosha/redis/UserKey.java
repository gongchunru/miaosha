package com.gchr.miaosha.redis;


/**
 * @author gongchunru
 * @email gongchunru@gmail.com
 * Date：2018/1/10 20:09
 */
public class UserKey extends BasePrefix {
    public UserKey(String prefix) {
        super(prefix);
    }

    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");
}
