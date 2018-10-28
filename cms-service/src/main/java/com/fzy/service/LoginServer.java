package com.fzy.service;

import com.alibaba.fastjson.JSONObject;
import com.fzy.utils.HttpUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: LoginServer
 * @description:
 * @author: fzy
 * @date: 2018-10-24 12:48
 **/
@Service
@Data
@Slf4j
public class LoginServer {

    @Value("${wx.appId}")
    private String appId;

    @Value("${wx.url}")
    private String url;

    @Value("${wx.secret}")
    private String secret;

    @Value("${wx.grant_type}")
    private String grant_type;

    /**
     * 通过code 去微信服务器换取openid
     * @param code
     * @return
     */
    public String login(String code){
        Map<String,String> map=new HashMap<>();
        map.put("js_code",code);
        map.put("appid",appId);
        map.put("secret",secret);
        map.put("grant_type",grant_type);
        String json = HttpUtil.sendPost(url, map);
        log.debug("用户登陆信息:"+json);
        JSONObject jsonObject=JSONObject.parseObject(json);
        String errcode = (String) jsonObject.get("errcode");
        if(null != errcode) {
            log.error("用户登陆失败:"+json);
            return null;
        }
        return (String) jsonObject.get("openid");
    }
}
