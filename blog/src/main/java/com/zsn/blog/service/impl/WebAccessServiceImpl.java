package com.zsn.blog.service.impl;

import com.zsn.blog.entity.WebsiteAccess;
import com.zsn.blog.entity.WebsiteConfig;
import com.zsn.blog.repository.WebsiteAccessRepository;
import com.zsn.blog.service.WebsiteAccessService;
import com.zsn.blog.service.WebsiteConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName WebAccessServiceImpl
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 9:23
 * @Version 1.0
 **/
@Service
public class WebAccessServiceImpl implements WebsiteAccessService {

    @Autowired
    private WebsiteAccessRepository websiteAccessRepository;


    @Override
    public WebsiteAccess getByAccessDateIs(Date accessDate) {
        return websiteAccessRepository.getByAccessDateIs(accessDate);
    }

    @Override
    public void save(WebsiteAccess websiteAccess) {
        websiteAccessRepository.save(websiteAccess);
    }
}
