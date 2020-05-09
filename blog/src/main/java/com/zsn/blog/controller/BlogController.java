package com.zsn.blog.controller;

import com.zsn.blog.constants.Constants;
import com.zsn.blog.entity.Article;
import com.zsn.blog.service.ArticleService;
import com.zsn.blog.util.HtmlSpirit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @ClassName BlogController
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/6 9:52
 * @Version 1.0
 **/
@Controller
public class BlogController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/blog")
    public String blog(Model model) {
        return this.blog(model, 1);
    }

    @GetMapping("/blog/{pageNumber}")
    public String blog(Model model, @PathVariable Integer pageNumber) {
        if (pageNumber == null) {
            pageNumber = 1;
        }
        Page<Article> articlePage = articleService.findBlogArticleList((pageNumber-1)*Constants.defaultPageSize,Constants.defaultPageSize );
        List<Article> articleList = articlePage.getContent();
        articleList.forEach(article -> {
            String articleIntroduction = HtmlSpirit.delHtmlTag(article.getArticleContent());
            article.setArticleIntroduction(articleIntroduction.length() > 100 ? articleIntroduction.substring(0, 100) : articleIntroduction);
        });
        model.addAttribute("articleList", articleList);
        model.addAttribute("totalCount", articlePage.getTotalElements());
        model.addAttribute("pageNumber", pageNumber);
        return "blog";
    }
}

