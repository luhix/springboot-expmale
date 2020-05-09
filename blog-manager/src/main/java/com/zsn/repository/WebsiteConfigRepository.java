package com.zsn.repository;

import com.zsn.entity.WebsiteConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName WebsiteConfigRepository
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 17:26
 * @Version 1.0
 **/
public interface WebsiteConfigRepository extends JpaRepository<WebsiteConfig, Long> {
}
