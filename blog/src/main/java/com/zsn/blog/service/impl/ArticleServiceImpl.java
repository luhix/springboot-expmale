package com.zsn.blog.service.impl;

import com.zsn.blog.constants.Constants;
import com.zsn.blog.entity.Article;
import com.zsn.blog.repository.ArticleRepository;
import com.zsn.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName ArticleServiceImpl
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/5 17:51
 * @Version 1.0
 **/
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> findIsTopArticleList() {
        Pageable pageable = PageRequest.of(0, 6, Sort.Direction.DESC, "articleId");
        Page<Article> page = articleRepository.findAllByIsTopAndIsEnable(Constants.YES, Constants.YES, pageable);
        List<Article> articleList = page.getContent();
        for (int i = 0; i < articleList.size(); i++) {
            Article article = articleList.get(i);
            article.setImageNo(i+1);
        }
        return articleList;
    }

    @Override
    public Page<Article> findBlogArticleList(int page, int size) {
        System.out.println(page);
        System.out.println(size);
        Pageable pageable = PageRequest.of(page,size,Sort.Direction.DESC, "articleId");
        return articleRepository.findAllByIsEnable(Constants.YES, pageable);
    }

    @Override
    public Page<Article> findSearchArticleList(int page, int size, String keyword) {
        Pageable pageable = PageRequest.of(page,size,Sort.Direction.DESC, "articleId");
        return articleRepository.findAllByIsEnable(Constants.YES, pageable);
    }

    @Override
    public Article findArticleByArticleId(Long articleId) {
        Optional<Article> optionalArticle = articleRepository.findById(articleId);
        if (optionalArticle.isPresent()) {
            return optionalArticle.get();
        }
        return null;
    }

    @Override
    public Article findIsEnableArticleByArticleId(Long articleId) {
        return articleRepository.findByIsEnableAndArticleId(Constants.YES, articleId);
    }

    @Override
    public void saveArticle(Article article) {
        articleRepository.save(article);
    }
}
