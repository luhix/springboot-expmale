package com.zsn.service;

import com.zsn.entity.WebsiteAccess;

import java.util.Date;
import java.util.List;

/**
 * @ClassName WebsiteAccessService
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 14:41
 * @Version 1.0
 **/
public interface WebsiteAccessService {

    WebsiteAccess getByAccessDateIs(Date accessDate);

    void save(WebsiteAccess websiteAccess);

    Integer sumWebsiteAccess(Date date, Integer days);

    List<WebsiteAccess> findChartsWebsiteAccess();

}
