package org.bite.recaptcha.model;

import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-17
 * Time: 22:21
 */
@Data
public class UserInfo {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private Integer gender;
    private String phoneNumber;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;

    private Integer ArticleID;
}
