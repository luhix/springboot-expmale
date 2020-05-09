package com.zsn.service.impl;

import com.zsn.service.AuthenticationService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @ClassName AuthenticationServiceImpl
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 17:23
 * @Version 1.0
 **/
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
