package com.zsn.service;

import org.springframework.security.core.Authentication;

/**
 * @ClassName AuthenticationService
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 17:19
 * @Version 1.0
 **/
public interface AuthenticationService {
    Authentication getAuthentication();
}
