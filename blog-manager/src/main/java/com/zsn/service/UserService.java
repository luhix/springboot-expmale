package com.zsn.service;

import com.zsn.entity.Pages;
import com.zsn.entity.User;
import org.springframework.data.domain.Page;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 17:40
 * @Version 1.0
 **/
public interface UserService {

    Page<User> findAllBySearch(Pages pages, Long userId, String username);

    User findUserByUserId(Long userId);

    String saveOrUpdateUser(User user);

    void updateUserIsEnable(Long userId, Integer isEnable);

    void deleteUser(Long userId);

    User findByUsername(String username);

}
