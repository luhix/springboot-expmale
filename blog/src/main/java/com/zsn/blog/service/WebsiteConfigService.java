package com.zsn.blog.service;

import com.zsn.blog.entity.WebsiteConfig;

/**
 * @ClassName WebsiteConfigService
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/6 15:03
 * @Version 1.0
 **/
public interface WebsiteConfigService {

    WebsiteConfig findWebsiteConfig();

    void saveWebsiteConfig(WebsiteConfig websiteConfig);

}
