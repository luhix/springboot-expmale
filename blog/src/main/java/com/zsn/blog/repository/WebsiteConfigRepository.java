package com.zsn.blog.repository;

import com.zsn.blog.entity.WebsiteConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName WebsiteConfigRepository
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/6 15:08
 * @Version 1.0
 **/
public interface WebsiteConfigRepository extends JpaRepository<WebsiteConfig, Long> {
}
