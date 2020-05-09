package com.zsn.repository;

import com.zsn.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Date;

/**
 * @ClassName ArticleRepository
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 14:45
 * @Version 1.0
 **/
public interface ArticleRepository extends JpaRepository<Article, Long>, JpaSpecificationExecutor<Article> {
    Integer countByArticleInputDate(Date articleInputDate);
}
