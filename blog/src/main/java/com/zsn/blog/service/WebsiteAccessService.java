package com.zsn.blog.service;

import com.zsn.blog.entity.WebsiteAccess;

import java.util.Date;

/**
 * @ClassName WebsiteAccessService
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 9:20
 * @Version 1.0
 **/
public interface WebsiteAccessService {

    WebsiteAccess getByAccessDateIs(Date accessDate);
    void save(WebsiteAccess websiteAccess);
}
