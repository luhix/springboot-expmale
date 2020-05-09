package com.zsn.blog.controller;

import com.zsn.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/5 17:04
 * @Version 1.0
 **/
@Controller
public class IndexController {

    @Autowired
    private ArticleService articleService;

    @GetMapping(value = {"/","index"})
    public String index(Model model) {

        model.addAttribute("articleList", articleService.findIsTopArticleList());
        return "index";
    }
}
