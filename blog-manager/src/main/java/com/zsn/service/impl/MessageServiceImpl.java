package com.zsn.service.impl;

import com.zsn.constants.Constants;
import com.zsn.entity.Message;
import com.zsn.entity.Pages;
import com.zsn.repository.MessageRepository;
import com.zsn.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName MessageServiceImpl
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 15:10
 * @Version 1.0
 **/
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void updateMessageIsRead(Long messageId) {

    }

    @Override
    public void deleteMessage(Long messageId) {

    }

    @Override
    public Message findMessageByMessageId(Long messageId) {
        return null;
    }

    @Override
    public int countByIsRead(Integer isRead) {
        return messageRepository.countByIsRead(isRead);
    }

    @Override
    public Page<Message> findAllMessageBySearch(Pages pages, String name, String email) {
        return null;
    }

    @Override
    public List<Message> findAllByIsRead(Integer isRead) {
        return messageRepository.findAllByIsRead(Constants.NO);
    }

    @Override
    public Long count() {
        return messageRepository.count();
    }
}
