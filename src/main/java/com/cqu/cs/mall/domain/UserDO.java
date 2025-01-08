package com.cqu.cs.mall.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserDO {
    /**
     * 主键id
     */
    private int id;
    /**
     * 用户id
     */
    @ExcelProperty("reviewerID")
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
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private String gender;
    /**
     * 头像地址
     */
    private String avatar;
    /**
     * 地址
     */
    private String address;
    /**
     * 创建时间
     */
    private Timestamp createTime;
    /**
     * 更新时间
     */
    private Timestamp updateTime;


}