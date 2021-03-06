package com.zsn.blog.controller;

import com.zsn.blog.entity.Message;
import com.zsn.blog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @ClassName ContactController
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/6 15:51
 * @Version 1.0
 **/
@Controller
public class ContactController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @PostMapping("/contact/sendMail")
    @ResponseBody
    @Transactional(rollbackFor = Throwable.class)
    public String sendMail(@RequestBody Message message) {
        message.setMessageInputDate(new Date());
        messageService.saveMessage(message);
        return "success";
    }

}
