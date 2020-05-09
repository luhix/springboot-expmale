package com.zsn.service.impl;

import com.zsn.constants.Constants;
import com.zsn.entity.Pages;
import com.zsn.entity.Role;
import com.zsn.entity.User;
import com.zsn.repository.UserRepository;
import com.zsn.service.RoleService;
import com.zsn.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 17:44
 * @Version 1.0
 **/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Override
    public Page<User> findAllBySearch(Pages pages, Long userId, String username) {
        return null;
    }

    @Override
    public User findUserByUserId(Long userId) {

        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }

        return null;
    }

    @Override
    public String saveOrUpdateUser(User user) {

        List<Role> roleList = new ArrayList<>();
        List<Long> roleIds = user.getRoleIdList();
        if (CollectionUtils.isNotEmpty(roleIds)) {
            for (Long roleId : roleIds) {
                Role role = roleService.findRoleByRoleId(roleId);
                roleList.add(role);
            }

            user.setRoleList(roleList);
        }

        if (user.getUserId() == null) {
            user.setIsEnable(Constants.NO);
        } else if (userRepository.findByUsername(user.getUsername()) != null) {
            return "用户名存在";
        }


        userRepository.save(user);

        return "保存成功";
    }

    @Override
    public void updateUserIsEnable(Long userId, Integer isEnable) {

    }

    @Override
    public void deleteUser(Long userId) {

    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
