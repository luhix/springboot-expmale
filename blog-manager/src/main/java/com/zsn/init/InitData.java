package com.zsn.init;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.zsn.entity.Role;
import com.zsn.entity.User;
import com.zsn.entity.WebsiteConfig;
import com.zsn.repository.RoleRepository;
import com.zsn.service.UserService;
import com.zsn.service.WebsiteConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

/**
 * @ClassName InitData
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/8 9:10
 * @Version 1.0
 **/
@Component
public class InitData {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private WebsiteConfigService websiteConfigService;

    @PostConstruct
    private void initRoleData() {
        Role role1 = new Role(1L, "ROLE_USER", 1);
        Role role2 = new Role(2L, "ROLE_ADMIN", 1);
        Role role3 = new Role(3L, "ROLE_SUPERADMIN", 1);
        Role role4 = new Role(4L, "ROLE_SYSTEMADMIN", 1);

        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(role1);
        roleList.add(role2);
        roleList.add(role3);
        roleList.add(role4);

        roleRepository.saveAll(roleList);
        User user = userService.findUserByUserId(1L);
        System.out.println(user + "------------------------------------------------------------------------------");
        if (user == null) {
            userService.saveOrUpdateUser(new User(1L, "admin", "123", "admin@springboot.cn", 1, roleList));
        }
        WebsiteConfig websiteConfig = websiteConfigService.findWebsiteConfig();

        if (websiteConfig == null) {
            websiteConfigService.saveWebsiteConfig(new WebsiteConfig(1L, "SpringBoot博客", "dalaoyang", 7L, "辽ICP备17014944号-1", "Dalaoyang.cn", "dalaoyang@aliyun.com"));
        }

    }

}
