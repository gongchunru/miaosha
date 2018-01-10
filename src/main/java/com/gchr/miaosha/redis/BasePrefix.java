package com.gchr.miaosha.redis;

/**
 * @author gongchunru
 * @email gongchunru@gmail.com
 * Date：2018/1/10 19:54
 */
public abstract class BasePrefix implements KeyPrefix{

    private int expireSeconds;

    private String prefix;

    public BasePrefix(String prefix) { //0 代表永不过期
        this(0,prefix);
    }

    public BasePrefix(int expireSeconds,String prefix){
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    public int expireSeconds() {//默认0代表永不过期
        return expireSeconds;
    }


    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className+":" + prefix;
    }

}
