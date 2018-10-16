package com.fzy.utils;

import com.fzy.entity.vo.ResultVo;

/**
 * @program: ResultVOUtil
 * @description: http请求返回的最外层对象
 * @author: fzy
 * @date: 2018-10-07 09:11
 **/
public class ResultVOUtil{

    public static ResultVo success(Object object) {
        ResultVo resultVO = new ResultVo();
        resultVO.setData(object);
        resultVO.setCode(200);
        resultVO.setSuccess(true);
        resultVO.setMsg(null);
        return resultVO;
    }

    public static ResultVo success() {
        return success(null);
    }

    public static ResultVo error(Integer code, String msg) {
        ResultVo resultVO = new ResultVo();
        resultVO.setCode(code);
        resultVO.setSuccess(false);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
