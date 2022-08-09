package com.inside.interview.service.interfaces;

import com.inside.interview.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface MessageService {

    Message saveMessage(Message message);

    Page<Message> getHistoryMessages();

}