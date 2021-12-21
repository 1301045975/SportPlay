package com.sport.sportplay.service;
import com.sport.sportplay.dao.UserDao;
import com.sport.sportplay.entity.User;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> getAllUser(){
        return userDao.getAllUser();
    }

    public User loginUser(User user){
        return userDao.loginUser(user);
    }

    public User getOneUser(Integer id){
        return userDao.getOneUser(id);
    }

    public int addUser(User user){
        return userDao.addUser(user);
    }
    public int updateUser(User user){
        return userDao.updateUser(user);
    }
    public int deleteUser(Integer id){
        return userDao.deleteUser(id);
    }
}
