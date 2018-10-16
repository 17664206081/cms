package com.fzy.exception;


import com.fzy.entity.enums.ResultEnum;

/**
 * @program: DemoException
 * @description: 自定义异常
 * @author: fzy
 * @create: 2018-09-17 18:54
 **/
public class WebException extends RuntimeException {

    private Integer code;

    public WebException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public WebException(Integer code, String message) {
        super(message);
        this.code=code;
    }
}
