package com.hxh.aoplog.repository;

import com.hxh.aoplog.dto.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: H_xinghai
 * @Date: 2019/5/31 16:36
 * @Description:
 */

public interface UserDetailRepository extends JpaRepository<UserDetail,Integer> {

}
