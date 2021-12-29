package com.sport.sportplay.controller;

import com.sport.sportplay.dao.LoginDao;
import com.sport.sportplay.entity.User;
import com.sport.sportplay.service.LoginService;
import com.sport.sportplay.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/login")
@Api(value = "测试接口", tags = "用户登录")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    //登录
    @PostMapping("/login")
    @ApiOperation(value = "用户登录", notes = "登录")
    public Msg login(String username,String password){
        User s = loginService.loginUser(username,password);
        if(s != null){
            String token = UUID.randomUUID().toString().replaceAll("-","");
            //将用户的ID信息存入redis缓存，并设置一小时的过期时间
            stringRedisTemplate.opsForValue().set(token,String.valueOf(s.getId()),3600, TimeUnit.SECONDS);
            return Msg.success().add("token",token).add("info","登陆成功");
        }else{
            return Msg.fail().add("info","登陆失败");
        }
    }
    @PostMapping("/other")
    public Msg other() {
        return Msg.success().add("info", "该接口是来测试的");
    }

}
