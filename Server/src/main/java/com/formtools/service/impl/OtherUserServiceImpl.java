package com.formtools.service.impl;

import com.formtools.mapper.UserMapper;
import com.formtools.model.UserInfo;
import com.formtools.model.UserVerify;
import com.formtools.service.OtherUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author myl
 * @create 2020-02-23  23:34
 */
@Service
public class OtherUserServiceImpl implements OtherUserService {
    @Resource
    private UserMapper userMapper;

    public Long updateUser(String nickname,String profile,String openid){
        UserVerify userVerify=userMapper.getUserVerify(openid);
//        System.out.println(userVerify);
        Long userId;
        int n;
        if(userVerify!=null){
            userId=userVerify.getUserId();
            n=userMapper.updateUserInfo(new UserInfo(userId,nickname,profile));
        }else {
            userId=System.currentTimeMillis();//需要优化，保证userId的唯一性
            n=userMapper.addUserVerify(new UserVerify(null,userId,openid,'Y'));
            if(n==1){
                n=userMapper.addUserInfo(new UserInfo(userId,nickname,profile));
            }else return null;
        }
        if(n==1)return userId;
        return null;
    }
}
