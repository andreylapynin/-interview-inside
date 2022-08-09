package com.inside.interview.controller;

import com.inside.interview.entity.Message;
import com.inside.interview.service.interfaces.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class MessageController {
    private MessageService messageService;

    @GetMapping("/message")
    public List<Message> saveOrGetMessage(@RequestBody Message message) {
        try {
            if (message.getTextMessage().toLowerCase().equals("history 10")) {
                return messageService.getHistoryMessages().getContent();
            } else {
                List<Message> messageList = new ArrayList<>();
                messageList.add(messageService.saveMessage(message));
                return messageList;
            }
        } catch (NoResultException e) {
            throw new UsernameNotFoundException("No user found");
        }
    }

}