package com.zsn.blog.service.impl;

import com.zsn.blog.entity.Link;
import com.zsn.blog.repository.LinkRepository;
import com.zsn.blog.service.LinkService;
import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName LinkServiceImpl
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 9:49
 * @Version 1.0
 **/

@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkRepository linkRepository;

    @Override
    public List<Link> findAllByIsEnable() {
        return linkRepository.findAll();
    }
}
