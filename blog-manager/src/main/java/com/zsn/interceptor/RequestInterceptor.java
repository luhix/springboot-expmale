package com.zsn.interceptor;

import com.zsn.constants.Constants;
import com.zsn.entity.Message;
import com.zsn.entity.User;
import com.zsn.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @ClassName RequestInterceptor
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 17:17
 * @Version 1.0
 **/
@Component
public class RequestInterceptor  extends HandlerInterceptorAdapter {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private WebsiteConfigService websiteConfigService;

    @Autowired
    private TagService tagService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            ModelMap modelMap = modelAndView.getModelMap();
            Date date = new Date();

            Authentication authentication = authenticationService.getAuthentication();

            System.out.println(authentication+ "==================");

            if (authentication != null) {
                String name = authentication.getName();
                modelMap.addAttribute("username", name);
                System.out.println("==============11111================" + name);
                User byUsername = userService.findByUsername(name);
                System.out.println("==============11111================" + byUsername);
                if (byUsername != null) {
                    System.out.println("======================333333333333333=============333333333333333========");
                    // 赋值用户所拥有菜单集合，动态渲染菜单
                    modelMap.addAttribute("userRoleList", Constants.getUserRoleList(byUsername.getRoleList()));
                }
            }

            Integer messageCount = messageService.countByIsRead(Constants.NO);
            modelMap.addAttribute("messageCount", messageCount);

            Integer tagCount = tagService.countByTagInputDate(date);
            modelMap.addAttribute("tagCount", tagCount);

            Integer articleCount = articleService.countByArticleInputDate(date);
            modelMap.addAttribute("articleCount", articleCount);

            Integer total = articleCount + tagCount + messageCount;
            modelMap.addAttribute("sumCount",total );

            List<Message> allByIsRead = messageService.findAllByIsRead(Constants.NO);
            modelMap.addAttribute("mainbarMessageList", allByIsRead);
            modelMap.addAttribute("mainbarMessageListCount", allByIsRead.size());
            modelMap.addAttribute("websiteConfig", websiteConfigService.findWebsiteConfig());
        }
    }
}
