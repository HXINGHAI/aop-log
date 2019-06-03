package com.hxh.aoplog.aop;

import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hxh.aoplog.dto.UserDetail;
import com.hxh.aoplog.requestandresponse.Request;
import com.hxh.aoplog.requestandresponse.Response;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;




/**
 * @Author: H_xinghai
 * @Date: 2019/5/31 15:23
 * @Description:
 */
@Aspect
@Component
public class LogRecordAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogRecordAspect.class);

    //定义切点

    @Pointcut("@annotation(com.hxh.aoplog.annotation.CurrentLog)")
    public void logPointCut(){

    }

    //执行插入方法前的拦截（获取入参）
    @Before("logPointCut()")
    public void runBeforeMethod(JoinPoint joinPoint){
        logger.info("===========开始执行=========");
        Object[] objects = joinPoint.getArgs();
        for (Object result:objects) {
            if (result instanceof Request){
                String params = JSON.toJSONString(result, SerializerFeature.WriteMapNullValue);
                logger.info("通知的签名=======>{}",joinPoint.getSignature());
                logger.info("方法入参========>{}",params);
            }
        }
    }
    //方法执行后拦截   获取结果参数

    @AfterReturning(value = "logPointCut()",returning = "result")
    public void runAfterMethod(JoinPoint joinPoint,Object result) {
       //   Object[] returnParams = joinPoint.getArgs();      //这个是获取入参的
          logger.info("通知的签名=======>{}",joinPoint.getSignature());
          if (result != null && (result instanceof Response)){
              String params = JSON.toJSONString(result,SerializerFeature.WriteMapNullValue);
              logger.info("========返回参数======={}",params);
          }else {
              logger.info(null);
          }
    }

// @After("logPointCut()")
//    public void runAfterMethod(JoinPoint joinPoint) {
//          Object[] returnParams = joinPoint.getArgs();
//        //  UserDetail userDetail = (UserDetail) result.getData();
////        for (UserDetail response:userDetail) {
////            if (response instanceof UserDetail){
//        String params = JSON.toJSONString(returnParams,SerializerFeature.WriteMapNullValue);
//        logger.info("========返回参数=======",params);
////                logger.info("===========详细=========",response);
////            }
////        }
//    }
}
