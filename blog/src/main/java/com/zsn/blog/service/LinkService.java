package com.zsn.blog.service;

import com.zsn.blog.entity.Link;

import java.util.List;

/**
 * @ClassName LinkService
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 9:48
 * @Version 1.0
 **/
public interface LinkService {

    List<Link> findAllByIsEnable();

}
