package com.zsn.blog.interceptors;

import com.zsn.blog.entity.WebsiteAccess;
import com.zsn.blog.service.LinkService;
import com.zsn.blog.service.TagService;
import com.zsn.blog.service.WebsiteAccessService;
import com.zsn.blog.service.WebsiteConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


/**
 * @ClassName RequestInterceptor
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 9:18
 * @Version 1.0
 **/
@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

    Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

    @Autowired
    private WebsiteAccessService websiteAccessService;

    @Autowired
    private TagService tagService;

    @Autowired
    private LinkService linkService;

    @Autowired
    private WebsiteConfigService websiteConfigService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        if (modelAndView != null) {
            ModelMap modelMap = modelAndView.getModelMap();
            logger.info("正在更新网站访问次数...");
            WebsiteAccess websiteAccess = websiteAccessService.getByAccessDateIs(new Date());
            websiteAccess.setAccessCount(websiteAccess.getAccessCount() + 1);
            websiteAccessService.save(websiteAccess);
            logger.info("初始化底部数据...");

            modelMap.addAttribute("tagList", tagService.findAll());
            modelMap.addAttribute("linkList", linkService.findAllByIsEnable());
            modelMap.addAttribute("websiteConfig", websiteConfigService.findWebsiteConfig());

        }

    }
}
