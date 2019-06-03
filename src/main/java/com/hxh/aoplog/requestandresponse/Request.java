package com.hxh.aoplog.requestandresponse;

import lombok.Data;

/**
 * @Author: H_xinghai
 * @Date: 2019/5/31 16:12
 * @Description:
 */
@Data
public class Request <T>{
    private String num;
    private String size;
    private T params;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }



    public T getParams() {
        return params;
    }

    public void setParams(T params2) {
        this.params = params2;
    }
}
