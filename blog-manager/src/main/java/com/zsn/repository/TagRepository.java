package com.zsn.repository;

import com.zsn.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Date;

/**
 * @ClassName TagRepository
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 16:24
 * @Version 1.0
 **/
public interface TagRepository extends JpaRepository<Tag, Long>, JpaSpecificationExecutor<Tag> {

    Tag findByTagName(String tagName);

    Integer countByTagInputDate(Date tagInputDate);
}
