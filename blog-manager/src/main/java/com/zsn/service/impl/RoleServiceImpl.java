package com.zsn.service.impl;

import com.zsn.entity.Role;
import com.zsn.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RoleServiceImpl
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/8 9:14
 * @Version 1.0
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Override
    public Role findRoleByRoleId(Long roleId) {
        return null;
    }

    @Override
    public List<Role> findAllByIsEnable() {
        return null;
    }
}
