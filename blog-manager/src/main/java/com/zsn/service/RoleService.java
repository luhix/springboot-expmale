package com.zsn.service;

import com.zsn.entity.Role;

import java.util.List;

/**
 * @ClassName RoleService
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/8 9:11
 * @Version 1.0
 **/
public interface RoleService {
    Role findRoleByRoleId(Long roleId);

    List<Role> findAllByIsEnable();
}
