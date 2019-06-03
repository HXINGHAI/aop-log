package com.hxh.aoplog.dto;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: H_xinghai
 * @Date: 2019/5/31 15:17
 * @Description:
 */

@Entity
@Table(name = "user_detail",schema = "java-test",catalog = "")
public class UserDetail {
        private Integer userId;
        private String address;
        private String work;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)     //JPA自增主键的设置 默认是AUTO ：代表主键由程序控制即自己手动设置，而IDENRTITY代表主键由数据库自动生成，即采用数据库ID自增长的方式
        @Column(name = "user_id")
        public Integer getUserId() {
                return userId;
        }

        public void setUserId(Integer userId) {
                this.userId = userId;
        }
        @Column(name = "address")
        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }
        @Column(name = "work")
        public String getWork() {
                return work;
        }

        public void setWork(String work) {
                this.work = work;
        }
}
