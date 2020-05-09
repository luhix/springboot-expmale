package com.zsn.service;

import com.zsn.entity.Link;
import com.zsn.entity.Pages;
import org.springframework.data.domain.Page;

/**
 * @ClassName LinkService
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 14:40
 * @Version 1.0
 **/
public interface LinkService {

    Page<Link> findAllBySearch(Pages pages, Long linkId, String linkName);

    Link findLinkByLinkId(Long linkId);

    void saveOrUpdateLink(Link link);

    void deleteLink(Long linkId);

    Long count();

}
