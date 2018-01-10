package com.gchr.miaosha.util;

import java.util.UUID;

/**
 * @author gongchunru
 * @email gongchunru@gmail.com
 * Date：2018/1/10 16:20
 */
public class UUIDUtil {
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
