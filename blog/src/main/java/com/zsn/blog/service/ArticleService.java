package com.zsn.blog.service;

import com.zsn.blog.entity.Article;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @ClassName ArticleService
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/5 17:50
 * @Version 1.0
 **/
public interface ArticleService {
    List<Article> findIsTopArticleList();

    Page<Article> findBlogArticleList(int page, int size);

    Page<Article> findSearchArticleList(int page, int size,String keyword);

    Article findArticleByArticleId(Long articleId);

    Article findIsEnableArticleByArticleId(Long articleId);

    void saveArticle(Article article);
}
