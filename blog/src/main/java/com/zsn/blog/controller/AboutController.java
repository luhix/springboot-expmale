package com.zsn.blog.controller;

import com.zsn.blog.entity.WebsiteConfig;
import com.zsn.blog.service.ArticleService;
import com.zsn.blog.service.WebsiteConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName AboutController
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/6 14:57
 * @Version 1.0
 **/
@Controller
public class AboutController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private WebsiteConfigService websiteConfigService;

    @GetMapping("/about")
    public String about(Model model) {
        WebsiteConfig websiteConfig = websiteConfigService.findWebsiteConfig();
        model.addAttribute("article", articleService.findArticleByArticleId(websiteConfig.getAboutPageArticleId()));
        return "about";
    }

}
