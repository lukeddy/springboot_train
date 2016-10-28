package com.tangzq.service.impl;

import com.tangzq.vo.UserInfoVo;
import com.tangzq.model.User;
import com.tangzq.repository.UserRepository;
import com.tangzq.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MyService接口实现类
 * Author tangzq.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);


    @Override
    public UserInfoVo findUserInfoById(String userId) {
        User user=userRepository.findOne(userId);
        if(null==user){
            logger.warn("警告，用户{}不存在",userId);
            return null;
        }
        return convertUserToVo(user);
    }

    @Override
    public UserInfoVo findUserInfoByPhone(String phone) {
        User user=userRepository.findByPhone(phone);
        if(null==user){
            logger.warn("警告，用户{}不存在",phone);
            return null;
        }
        return convertUserToVo(user);
    }

    @Override
    public String findUserFullNameById(String userId) {
        User user=userRepository.findOne(userId);
        if(null==user){
            logger.warn("警告，用户{}不存在",userId);
            return null;
        }
        return user.getFullname();
    }

    @Override
    public String findUserFullNameByPhone(String phone) {
        User user=userRepository.findByPhone(phone);
        if(null==user){
            logger.warn("警告，用户{}不存在",phone);
            return null;
        }
        return user.getFullname();
    }

    /**
     * 转成VO类
     * @param user
     * @return
     */
    private UserInfoVo convertUserToVo(User user){
        UserInfoVo vo=new UserInfoVo();
        vo.setId(user.getId());
        vo.setPhone(user.getPhone());
        vo.setFullname(user.getFullname());
        vo.setCreatedAt(user.getCreatedAt());
        vo.setUpdatedAt(user.getUpdatedAt());
        return  vo;
    }
}
