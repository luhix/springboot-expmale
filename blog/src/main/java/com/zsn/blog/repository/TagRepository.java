package com.zsn.blog.repository;

import com.zsn.blog.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName TagRepository
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/6 16:24
 * @Version 1.0
 **/
public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findByTagName(String tagName);
}
