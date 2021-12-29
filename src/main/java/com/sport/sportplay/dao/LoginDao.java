package com.sport.sportplay.dao;

import com.sport.sportplay.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao {

    //登录
    //@Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    public User loginUser(String username,String password);
}
