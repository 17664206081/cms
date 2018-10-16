package com.fzy.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: ResultVo
 * @description: 返回前端的包装
 * @author: fzy
 * @create: 2018-09-15 14:19
 **/
@Data
public class ResultVo implements Serializable {

    private Integer code;

    private String msg;

    private Boolean success;

    private Object data;
}
