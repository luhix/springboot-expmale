package com.zsn.service.impl;

import com.zsn.entity.Article;
import com.zsn.entity.Pages;
import com.zsn.repository.ArticleRepository;
import com.zsn.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName ArticleServiceImpl
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 15:08
 * @Version 1.0
 **/
@Service
public class ArticleServiceImpl implements ArticleService {


    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Page<Article> findAllBySearch(Pages pages, Long articleId, String articleName, String articleAuthors) {
        return null;
    }

    @Override
    public Article findArticleByArticleId(Long articleId) {
        return null;
    }

    @Override
    public void saveOrUpdateArticle(Article article) {

    }

    @Override
    public void updateArticleIsEnable(Long articleId, Integer isEnable) {

    }

    @Override
    public void deleteArticle(Long articleId) {

    }

    @Override
    public Integer countByArticleInputDate(Date articleInputDate) {
        return articleRepository.countByArticleInputDate(articleInputDate);
    }

    @Override
    public Long count() {
        return articleRepository.count();
    }
}
