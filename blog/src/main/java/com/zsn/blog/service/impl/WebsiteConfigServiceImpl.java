package com.zsn.blog.service.impl;

import com.zsn.blog.entity.WebsiteConfig;
import com.zsn.blog.repository.WebsiteConfigRepository;
import com.zsn.blog.service.WebsiteConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @ClassName WebsiteConfigServiceImpl
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/6 15:05
 * @Version 1.0
 **/
@Service
public class WebsiteConfigServiceImpl implements WebsiteConfigService {

    @Autowired
    private WebsiteConfigRepository websiteConfigRepository;

    @Override
    public WebsiteConfig findWebsiteConfig() {
        Optional<WebsiteConfig> websiteConfigOptional = websiteConfigRepository.findById(1L);
        if (websiteConfigOptional.isPresent()) {
            return websiteConfigOptional.get();
        }
        return null;
    }

    @Override
    public void saveWebsiteConfig(WebsiteConfig websiteConfig) {
        websiteConfigRepository.save(websiteConfig);
    }
}
