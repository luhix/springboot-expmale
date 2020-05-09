package com.zsn.blog.controller;

import com.zsn.blog.constants.Constants;
import com.zsn.blog.entity.Article;
import com.zsn.blog.service.ArticleService;
import com.zsn.blog.util.HtmlSpirit;
import org.parboiled.common.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @ClassName SearchController
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/6 14:37
 * @Version 1.0
 **/
@Controller
public class SearchController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/search")
    public String search(Model model, Integer pageNumber, String keyword) {
        if (StringUtils.isEmpty(keyword)) {
            return "search";
        } else if (pageNumber == null) {
            pageNumber = 1;
        }

        Page<Article> articlePage = articleService.findSearchArticleList((pageNumber-1) * Constants.defaultPageSize, Constants.defaultPageSize, keyword);
        List<Article> articleList = articlePage.getContent();
        articleList.forEach(article -> {
            String articleIntroduction = HtmlSpirit.delHtmlTag(article.getArticleContent());
            article.setArticleIntroduction(articleIntroduction.length() > 100 ? articleIntroduction.substring(0, 100) : articleIntroduction);
        });

        model.addAttribute("articleList", articleList);
        model.addAttribute("totalCount", articlePage.getTotalElements());
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("keyword", keyword);
        return "search";
    }

}
