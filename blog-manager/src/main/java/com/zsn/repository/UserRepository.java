package com.zsn.repository;

import com.zsn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName UserRepository
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 17:44
 * @Version 1.0
 **/
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    User findByUsername(String username);

}
