package com.zsn.service.impl;

import com.zsn.constants.Constants;
import com.zsn.entity.WebsiteAccess;
import com.zsn.repository.WebsiteAccessRepository;
import com.zsn.service.WebsiteAccessService;
import com.zsn.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

/**
 * @ClassName WebsiteAccessService
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 15:11
 * @Version 1.0
 **/
@Service
public class WebsiteAccessServiceImpl implements WebsiteAccessService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private WebsiteAccessRepository websiteAccessRepository;

    @Override
    public WebsiteAccess getByAccessDateIs(Date accessDate) {
        return null;
    }

    @Override
    public void save(WebsiteAccess websiteAccess) {

    }

    @Override
    public Integer sumWebsiteAccess(Date date, Integer days) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Integer> query = criteriaBuilder.createQuery(Integer.class);

        Root<WebsiteAccess> root = query.from(WebsiteAccess.class);

        query.select(criteriaBuilder.sum(root.get("accessCount")));

        if (days == null && date != null) {
            Predicate accessDate = criteriaBuilder.equal(root.get("accessDate"), date);
            query.where(accessDate);
        } else if( date != null) {
            Predicate accessDate = criteriaBuilder.between(root.get("accessDate"), DateUtils.getDateBefore(date, days), date);
            query.where(accessDate);
        }

        Integer singleResult = entityManager.createQuery(query).getSingleResult();
        if (singleResult == null) {
            singleResult = 0;
        }

        return singleResult;
    }

    @Override
    public List<WebsiteAccess> findChartsWebsiteAccess() {
        Pageable pageable = PageRequest.of(Constants.startPage, Constants.defaultPageSize, Sort.Direction.ASC, "accessDate");
        Page<WebsiteAccess> websiteAccessPage = websiteAccessRepository.findAll(pageable);
        return websiteAccessPage != null ? websiteAccessPage.getContent() : null;
    }
}
