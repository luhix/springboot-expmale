package com.zsn.blog.init;

import com.zsn.blog.entity.WebsiteAccess;
import com.zsn.blog.entity.WebsiteConfig;
import com.zsn.blog.service.WebsiteAccessService;
import com.zsn.blog.service.WebsiteConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * @ClassName InitWebsiteData
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 10:39
 * @Version 1.0
 **/
@Component
public class InitWebsiteData {

    @Autowired
    private WebsiteAccessService websiteAccessService;

    @Autowired
    private WebsiteConfigService websiteConfigService;

    @PostConstruct
    public void initWebsiteVisits() {

        // 查询当日是否存在博客访问表记录，不存在则插入
        if (websiteAccessService.getByAccessDateIs(new Date()) == null) {

            WebsiteAccess websiteAccess = new WebsiteAccess();
            websiteAccess.setAccessCount(1);
            websiteAccess.setAccessDate(new Date());
            websiteAccessService.save(websiteAccess);
        }

        // 查询当日是否存在博客配置表记录，若不存在，则插入
        if (websiteConfigService.findWebsiteConfig() == null) {
            WebsiteConfig websiteConfig = new WebsiteConfig();
            websiteConfig.setId(1L);
            websiteConfig.setAboutPageArticleId(7L);
            websiteConfig.setBlogName("Springboot 博客");
            websiteConfig.setAuthorName("dalaoyang");
            websiteConfig.setDomainName("daolaoyang.com");
            websiteConfig.setRecordNumber("粤ICP备12909434");
            websiteConfig.setEmailUsername("dalaoyang@qq.com");
            websiteConfigService.saveWebsiteConfig(websiteConfig);
        }
    }



}
