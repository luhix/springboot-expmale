package com.zsn.blog.service.impl;

import com.zsn.blog.entity.Tag;
import com.zsn.blog.repository.TagRepository;
import com.zsn.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TagServiceImpl
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/6 16:21
 * @Version 1.0
 **/
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public Tag findByTagName(String tagName) {
        return tagRepository.findByTagName(tagName);
    }
}
