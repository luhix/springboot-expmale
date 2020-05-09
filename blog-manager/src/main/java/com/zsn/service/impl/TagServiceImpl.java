package com.zsn.service.impl;

import com.zsn.entity.Pages;
import com.zsn.entity.Tag;
import com.zsn.repository.TagRepository;
import com.zsn.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName TagServiceImpl
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 15:10
 * @Version 1.0
 **/

@Service
public class TagServiceImpl implements TagService {


    @Autowired
    private TagRepository tagRepository;

    @Override
    public Page<Tag> findAllBySearch(Pages pages, Long tagId, String tagName) {
        return null;
    }

    @Override
    public Tag saveTag(Tag tag) {
        return null;
    }

    @Override
    public void deleteTagByTagId(String tagName) {

    }

    @Override
    public Tag findTagByTagName(String tagName) {
        return null;
    }

    @Override
    public Integer countByTagInputDate(Date tagInputDate) {
        return tagRepository.countByTagInputDate(tagInputDate);
    }

    @Override
    public Long count() {
        return tagRepository.count();
    }
}
