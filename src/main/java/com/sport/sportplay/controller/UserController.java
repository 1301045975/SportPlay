package com.sport.sportplay.controller;

import com.sport.sportplay.entity.User;
import com.sport.sportplay.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
@Api(value = "测试接口", tags = "用户管理相关的接口", description = "用户测试接口")
public class UserController {
    @Autowired
    private UserService userService;

    //查询全部用户
    @GetMapping(value = "/selectAll")
    @ApiOperation(value = "获取所有用户信息", httpMethod = "GET",notes = "查询所有用户信息")
    public List<User> SelectAll(){
        return userService.getAllUser();
    }

    //根据id查找用户
    @GetMapping(value = "/selectUserById")
    @ApiOperation(value = "根据id获取用户信息", notes = "根据id查询用户信息")
    public User SelectUserById(Integer id){
        return userService.getOneUser(id);
    }

    //新增用户
    @PostMapping(value = "/addUser")
    @ApiImplicitParam(name = "user", value = "新增用户数据")
    //说明是什么方法(可以理解为方法注释)
    @ApiOperation(value = "添加用户")
    public String addUser(String username,String password,String email,String role,boolean state){
        userService.addUser(username,password,email,role,state);
        return "add success!";
    }

    @PostMapping(value = "/updateUser")
    public String updateUser(User user){
        userService.updateUser(user);
        return "update success!";
    }

    @PostMapping(value = "/deleteUser")
    public String deleteUser(Integer id){
        userService.deleteUser(id);
        return "delete success!";
    }


}
