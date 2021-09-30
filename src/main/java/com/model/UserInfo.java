package com.model;

import lombok.Data;

/**
 * 模型层 UserInfo 类，对应数据库的 user_info 表
 */

/**
 * @author difeng
 * @Data 标签由 lombok 提供，可以简化实体类的工作，不需要手动实现 setter() 和 getter() 方法。
 * <p>
 * 注：idea 要安装 lombok 插件，maven 要添加 lombok 坐标
 */
@Data
public class UserInfo {
    private int id;
    private String userName;
    private String password;
    private String age;
    private String sex;
    private String permission;
    private String isDelete;
}