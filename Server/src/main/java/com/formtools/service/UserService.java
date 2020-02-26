package com.formtools.service;


import com.formtools.vo.ResultVo;

import javax.mail.MessagingException;
import com.formtools.model.UserModel;

import java.util.Map;

/**
 * @author myl
 * @create 2020-02-05  22:57
 */

public interface UserService {

    UserModel getUser(Map<String, Object> map);
    ResultVo sendEmailCode(String email) throws MessagingException;
    boolean addUser(UserModel userModel);
    boolean isTrueCode(UserModel userModel,String code);
    boolean register(UserModel userModel,String code);
}
