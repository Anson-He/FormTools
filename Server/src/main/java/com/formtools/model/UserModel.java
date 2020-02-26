package com.formtools.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

/**
 * @author myl
 * @create 2020-02-05  21:59
 */
public class UserModel {

    public interface register extends Default {}

    //用户id
    private String userId;

    @NotNull(groups = register.class)
    @NotEmpty(groups = register.class)
    @Email(groups = register.class)
    //邮箱
    private String email;

    @NotNull(groups = register.class)
    @NotEmpty(groups = register.class)
    //密码
    private String password;

    @NotNull(groups = register.class)
    @NotEmpty(groups = register.class)
    //昵称
    private String nickname;

    //头像
    private String profile;

    public UserModel() {
    }

    public UserModel(String userId, String nickname, String profile) {
        this.userId = userId;
        this.nickname = nickname;
        this.profile = profile;
    }

    public UserModel(String userId, String email, String password, String nickname, String profile) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.profile = profile;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"userId\":\"")
                .append(userId).append('\"');
        sb.append(",\"email\":\"")
                .append(email).append('\"');
        sb.append(",\"password\":\"")
                .append(password).append('\"');
        sb.append(",\"nickname\":\"")
                .append(nickname).append('\"');
        sb.append(",\"profile\":\"")
                .append(profile).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
