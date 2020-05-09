package com.zsn.service;

import com.zsn.entity.Message;
import com.zsn.entity.Pages;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @ClassName MessageService
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 14:41
 * @Version 1.0
 **/
public interface MessageService {

    void updateMessageIsRead(Long messageId);

    void deleteMessage(Long messageId);

    Message findMessageByMessageId(Long messageId);

    int countByIsRead(Integer isRead);

    Page<Message> findAllMessageBySearch(Pages pages, String name, String email);

    List<Message> findAllByIsRead(Integer isRead);

    Long count();

}
