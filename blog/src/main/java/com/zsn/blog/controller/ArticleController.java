package com.zsn.blog.controller;

import com.zsn.blog.entity.Article;
import com.zsn.blog.service.ArticleService;
import com.zsn.blog.util.MarkdownToHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName ArticleController
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/6 9:07
 * @Version 1.0
 **/
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article/{id}")
    public String viewArticle(Model model, @PathVariable Long id) {
        Article article = articleService.findIsEnableArticleByArticleId(id);
        article.setArticleReadingTime(article.getArticleReadingTime() + 1);
        articleService.saveArticle(article);
        article.setArticleShowContent(MarkdownToHtml.markDownToHtml(article.getArticleContent()));
        model.addAttribute("article", article);
        return "article";
    }

}
