package com.fzy.config;

import com.alibaba.druid.support.http.StatViewServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * @program: DruidStatViewServlet
 * @description: druid 配置
 * @author: fzy
 * @create: 2018-09-24 20:01
 **/
@WebServlet(urlPatterns = "/druid/*",
        initParams = {
                @WebInitParam(name="allow",value = ""),//白名单
                @WebInitParam(name="deny",value = ""),//黑名单
                @WebInitParam(name="loginUsername",value = "admin"),//登录用户名
                @WebInitParam(name="loginPassword",value = "admin"),//登录密码
                @WebInitParam(name="resetEnable",value = "false")//禁用HTML页面上的“Reset All”功能
        })
public class DruidStatViewServlet extends StatViewServlet {

}
