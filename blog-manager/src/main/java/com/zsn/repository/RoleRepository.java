package com.zsn.repository;

import com.zsn.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @ClassName RoleRepository
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/8 9:17
 * @Version 1.0
 **/
public interface RoleRepository extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {
    List<Role> findAllByIsEnable(Integer isEnable);
}
