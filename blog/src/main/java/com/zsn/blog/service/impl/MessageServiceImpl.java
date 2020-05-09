package com.zsn.blog.service.impl;

import com.zsn.blog.entity.Message;
import com.zsn.blog.repository.MessageRepository;
import com.zsn.blog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName MessageServiceImpl
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/6 16:00
 * @Version 1.0
 **/
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void saveMessage(Message message) {
        messageRepository.save(message);
    }
}
