package com.zsn.blog.controller;

import com.zsn.blog.entity.Tag;
import com.zsn.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName TagController
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/6 16:14
 * @Version 1.0
 **/
@Controller
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tag")
    public String tag(Model model) {
        model.addAttribute("tagList", tagService.findAll());
        return "tag";
    }

    @GetMapping("/tag/{tagName}")
    public String tag(Model model, @PathVariable String tagName) {
        Tag tag = tagService.findByTagName(tagName);
        model.addAttribute("tag", tag);
        model.addAttribute("articleList", tag.getArticleList());
        return "tagArticle";
    }

}
