package com.zsn.blog.timer;

import com.zsn.blog.entity.WebsiteAccess;
import com.zsn.blog.service.WebsiteAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName WebSiteTimer
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 10:48
 * @Version 1.0
 **/
@Component
public class WebSiteTimer {
    @Autowired
    private WebsiteAccessService websiteAccessService;
    @Scheduled(cron = "0 0 0 1/1 * ?")
    private void updateTodayWebsiteVisits() {
        WebsiteAccess websiteAccess = new WebsiteAccess();
        websiteAccess.setAccessCount(1);
        websiteAccess.setAccessDate(new Date());
        websiteAccessService.save(websiteAccess);
    }
}
