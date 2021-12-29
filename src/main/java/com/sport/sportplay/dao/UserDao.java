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



    //@Options(useGeneratedKeys = true, keyProperty = "id")
    //@Insert("insert into easyuser (username,password,email,role,state) values (#{username},#{password},#{email},#{role},#{state})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int addUser(User user);

    //@Update("update easyuser set name=#{name},password=#{password},email=#{email},role=#{role},state=#{state} where id=#{id}")
    int updateUser(User user);

    //@Delete("delete from easyuser where id=#{id}")
    int deleteUser(Integer id);

}
