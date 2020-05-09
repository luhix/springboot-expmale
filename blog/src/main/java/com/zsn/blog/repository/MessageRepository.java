package com.zsn.blog.repository;

import com.zsn.blog.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName MessageRepository
 * @Description TODO
 * @Author lhx
 * @Date 2020/5/6 16:01
 * @Version 1.0
 **/
public interface MessageRepository extends JpaRepository<Message, Long> {
}
