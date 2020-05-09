package com.zsn.service;

import com.zsn.entity.Article;
import com.zsn.entity.Pages;
import org.springframework.data.domain.Page;

import java.util.Date;

/**
 * @ClassName ArticleService
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 14:40
 * @Version 1.0
 **/
public interface ArticleService {
    Page<Article> findAllBySearch(Pages pages, Long articleId, String articleName, String articleAuthors);

    Article findArticleByArticleId(Long articleId);

    void saveOrUpdateArticle(Article article);

    void updateArticleIsEnable(Long articleId, Integer isEnable);

    void deleteArticle(Long articleId);

    Integer countByArticleInputDate(Date articleInputDate);

    Long count();

}
