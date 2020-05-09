package com.zsn.service;

import com.zsn.entity.Pages;
import com.zsn.entity.Tag;
import org.springframework.data.domain.Page;

import java.util.Date;

/**
 * @ClassName TagService
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 14:40
 * @Version 1.0
 **/
public interface TagService {

    Page<Tag> findAllBySearch(Pages pages, Long tagId, String tagName);

    Tag saveTag(Tag tag);

    void deleteTagByTagId(String tagName);

    Tag findTagByTagName(String tagName);

    Integer countByTagInputDate(Date tagInputDate);

    Long count();

}
