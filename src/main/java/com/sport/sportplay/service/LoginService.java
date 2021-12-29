package com.sport.sportplay.service;

import com.sport.sportplay.dao.LoginDao;
import com.sport.sportplay.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class LoginService {

    @Autowired
    LoginDao loginDao;

    public User loginUser(String username,String password){
        return loginDao.loginUser(username,password);
    }
}
