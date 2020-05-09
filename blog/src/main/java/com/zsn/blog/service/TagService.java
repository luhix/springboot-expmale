package com.zsn.blog.service;

import com.zsn.blog.entity.Tag;

import java.util.List;

/**
 * @ClassName TagService
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/6 16:16
 * @Version 1.0
 **/
public interface TagService {
    List<Tag> findAll();
    Tag findByTagName(String tagName);
}
