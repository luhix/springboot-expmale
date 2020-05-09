package com.zsn.repository;

import com.zsn.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName LinkRepository
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 16:21
 * @Version 1.0
 **/
public interface LinkRepository extends JpaRepository<Link, Long>, JpaSpecificationExecutor<Link> {
}
