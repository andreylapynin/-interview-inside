package com.inside.interview.service;

import com.inside.interview.entity.Message;
import com.inside.interview.repository.MessageRepository;
import com.inside.interview.service.interfaces.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageServiceImp implements MessageService {
    private static final int SIZE_HISTORY_MESSAGES = 10;
    private static final String PROPERTY_SORTING_HISTORY_MESSAGES = "id";

    private MessageRepository messageRepository;

    @Autowired
    public MessageServiceImp(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    @Transactional
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Page<Message> getHistoryMessages() {
        Pageable page = PageRequest.of(0, SIZE_HISTORY_MESSAGES, Sort.Direction.DESC
                , PROPERTY_SORTING_HISTORY_MESSAGES);
        return messageRepository.findAll(page);
    }

}