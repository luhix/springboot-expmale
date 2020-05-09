package com.zsn.service.impl;

import com.zsn.entity.Link;
import com.zsn.entity.Pages;
import com.zsn.repository.LinkRepository;
import com.zsn.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * @ClassName LinkServiceImpl
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 15:09
 * @Version 1.0
 **/

@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkRepository linkRepository;

    @Override
    public Page<Link> findAllBySearch(Pages pages, Long linkId, String linkName) {
        return null;
    }

    @Override
    public Link findLinkByLinkId(Long linkId) {
        return null;
    }

    @Override
    public void saveOrUpdateLink(Link link) {

    }

    @Override
    public void deleteLink(Long linkId) {

    }

    @Override
    public Long count() {
        return linkRepository.count();
    }
}
