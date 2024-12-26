package com.cqu.cs.mall.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
@Data
@Accessors(chain = true)
public class User {
    private int id; // 用户id
    private String accountId; // 账户id
    private String username; // 用户名
    private String password; // 密码
    private String email; // 邮箱
    private Timestamp createdTime; // 创建时间
    private Timestamp updatedTime; // 更新时间

    // 无参构造函数
    public User() {}


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", accountId='" + accountId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                '}';
    }
}