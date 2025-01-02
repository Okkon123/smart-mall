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
    /**
     * 主键id
     */
    private int id;
    /**
     * 用户id
     */
    private String reviewerId;
    /**
     * 用户名
     */
    private String reviewerName;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 创建时间
     */
    private Timestamp createTime;
    /**
     * 更新时间
     */
    private Timestamp updateTime;


    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", reviewerId='" + reviewerId + '\'' +
                ", reviewerName='" + reviewerName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}