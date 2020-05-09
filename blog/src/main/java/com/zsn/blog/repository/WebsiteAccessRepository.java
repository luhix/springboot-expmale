package com.zsn.blog.repository;

import com.zsn.blog.entity.WebsiteAccess;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

/**
 * @ClassName WebsiteAccessRepository
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 9:28
 * @Version 1.0
 **/
public interface WebsiteAccessRepository extends JpaRepository<WebsiteAccess, Long> {

    WebsiteAccess getByAccessDateIs(Date accessDate);
}
