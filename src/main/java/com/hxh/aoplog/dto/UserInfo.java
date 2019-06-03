package com.hxh.aoplog.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Author: H_xinghai
 * @Date: 2019/5/31 15:19
 * @Description:
 */
@Data
public class UserInfo {
    private String userId;
    private String userNickName;
    private String userSex;
    private String userRealName;
    private Integer status;
    private String userTel;
    private String userPassword;
    private String userDetail;
    private String userCardId;
    private Date createTime;
    private Date updateTime;
}
