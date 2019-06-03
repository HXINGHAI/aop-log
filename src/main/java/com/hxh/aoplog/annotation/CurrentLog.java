package com.hxh.aoplog.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: H_xinghai
 * @Date: 2019/5/31 15:29
 * @Description:
 */
@Target(ElementType.METHOD)       //注解放置的位置，这里作用在方法之上
@Retention(RetentionPolicy.RUNTIME)    //在什么时候执行注解
public @interface CurrentLog {
    String value() default "";
}
