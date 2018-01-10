package com.gchr.miaosha.exception;

import com.gchr.miaosha.result.CodeMsg;

/**
 * @author gongchunru
 * @email gongchunru@gmail.com
 * Date：2018/1/10 20:21
 */
public class GlobalException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private CodeMsg cm;

    public GlobalException(CodeMsg cm) {
        super(cm.toString());
        this.cm = cm;
    }

    public CodeMsg getCm() {
        return cm;
    }

}
