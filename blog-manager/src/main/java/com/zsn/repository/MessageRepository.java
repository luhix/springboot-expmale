package com.zsn.repository;

import com.zsn.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @ClassName MessageRepository
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/7 16:22
 * @Version 1.0
 **/
public interface MessageRepository extends JpaRepository<Message, Long>, JpaSpecificationExecutor<Message> {

    int countByIsRead(Integer isRead);

    List<Message> findAllByIsRead(Integer isRead);

}
