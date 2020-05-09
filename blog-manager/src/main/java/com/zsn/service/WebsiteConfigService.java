package com.zsn.service;

import com.zsn.entity.WebsiteConfig;

/**
 * @ClassName WebsiteConfigService
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 17:20
 * @Version 1.0
 **/
public interface WebsiteConfigService {

    WebsiteConfig findWebsiteConfig();

    void saveWebsiteConfig(WebsiteConfig websiteConfig);

}
