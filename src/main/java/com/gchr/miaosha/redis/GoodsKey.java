package com.gchr.miaosha.redis;

/**
 * @author gongchunru
 * @email gongchunru@gmail.com
 * Date：2018/1/13 17:55
 */
public class GoodsKey extends BasePrefix{
    private GoodsKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
    public static GoodsKey getGoodsList = new GoodsKey(60, "gl");
    public static GoodsKey getGoodsDetail = new GoodsKey(60, "gd");

}
