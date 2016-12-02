package com.tangzq.service;

import com.tangzq.mapper.UserMapper;
import com.tangzq.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zl on 2015/8/27.
 */

@Service
public class UserService {
    private static Logger logger = Logger.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    public List<User> getUserList(){
        logger.info("查找所有用户");
        List<User> userList=userMapper.findUserInfo();
        return userList;
    }

    public User getUser(int id){
        logger.info("查找单个用户");
        return userMapper.findUserById(id);
    }

    /**
     * 注解事物是否起作用需要验证
     * @param user
     * @return
     */
    //@Transactional
    public int addUser(User user){
        return userMapper.insertUser(user);
    }

}
