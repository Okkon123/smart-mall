package com.cqu.cs.mall.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserDO {
    private int userId; // 用户id
    private String username; // 用户名
    private String password; // 密码
    private String email; // 邮箱
    private String phone; // 手机号
    private Timestamp createTime; // 创建时间
    private Timestamp updateTime; // 更新时间


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", createdTime=" + createTime +
                ", updatedTime=" + updateTime +
                '}';
    }
}