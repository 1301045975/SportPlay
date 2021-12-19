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
@Api(value = "测试接口", tags = "用户的增删改查")
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
    @ApiOperation(value = "添加用户",notes = "填写信息添加用户")
    public String addUser(User user){
        userService.addUser(user);
        return "add success!";
    }

    @PostMapping(value = "/updateUser")
    @ApiOperation(value = "修改用户",notes = "根据用户的id修改用户信息")
    public String updateUser(User user){
        userService.updateUser(user);
        return "update success!";
    }

    @PostMapping(value = "/deleteUser")
    @ApiOperation(value = "删除用户",notes = "根据用户id删除该用户信息")
    public String deleteUser(Integer id){
        userService.deleteUser(id);
        return "delete success!";
    }


}
