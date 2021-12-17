package com.sport.sportplay.dao;


import com.sport.sportplay.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Mapper
public interface UserDao {
    //@Select("SELECT * FROM easyuser")
    List<User> getAllUser();

    User getOneUser(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into easyuser (username,password,email,role,state) values (#{username},#{password},#{email},#{role},#{state})")
    Integer addUser(String username,String password,String email,String role,boolean state);

    @Update("update easyuser set name=#{name},password=#{password},email=#{email},role=#{role},state=#{state} where id=#{id}")
    Integer updateUser(User user);

    @Delete("delete from easyuser where id=#{id}")
    Integer deleteUser(Integer id);

}
