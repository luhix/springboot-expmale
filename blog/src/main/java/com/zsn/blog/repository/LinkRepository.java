package com.zsn.blog.repository;

import com.zsn.blog.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName LinkRepository
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 9:47
 * @Version 1.0
 **/
public interface LinkRepository  extends JpaRepository<Link, Long> {
}
