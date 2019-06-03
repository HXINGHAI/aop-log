package com.hxh.aoplog.controller;

import com.hxh.aoplog.annotation.CurrentLog;
import com.hxh.aoplog.dto.UserDetail;
import com.hxh.aoplog.repository.UserDetailRepository;
import com.hxh.aoplog.requestandresponse.Request;
import com.hxh.aoplog.requestandresponse.Response;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: H_xinghai
 * @Date: 2019/5/31 16:41
 * @Description:
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDetailRepository userDetailRepository;

    @PostMapping("/detailinsert")
    @CurrentLog(value = "插入数据")
    public void insert(@RequestBody Request<UserDetail> userDetailRequest){
        userDetailRepository.save(userDetailRequest.getParams());
    }

    @PostMapping("/detailfindall")
    @CurrentLog(value = "查询数据")
    public Response findAll(){
        Response result = new Response();
        result.setCode("200");
        result.setMsg("success");
        result.setData(userDetailRepository.findAll());
        return result;
    }
}
