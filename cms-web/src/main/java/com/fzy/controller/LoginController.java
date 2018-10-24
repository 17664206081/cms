package com.fzy.controller;

import com.alibaba.fastjson.JSONObject;
import com.fzy.entity.vo.ResultVo;
import com.fzy.service.LoginServer;
import com.fzy.utils.HttpUtil;
import com.fzy.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.Map;

/**
 * @program: LoginController
 * @description:
 * @author: fzy
 * @date: 2018-10-23 12:51
 **/
@RestController
@RequestMapping("/buyer")
@Api(tags="用户登陆")
@Slf4j
public class LoginController {

    @Autowired
    private LoginServer loginServer;

    @GetMapping("/login")
    private ResultVo login(@Param("code") String code){
        try {
            String openId=loginServer.login(code);
            if(null!=openId){
                return ResultVOUtil.success(openId);
            }
            return ResultVOUtil.error(505,"获取openId失败");
        } catch (Exception e) {
            log.error("登陆失败"+e.getMessage());
            return ResultVOUtil.error(505,"登陆失败");
        }
    }


}
