package com.inside.interview.service;

import com.inside.interview.entity.Message;
import com.inside.interview.repository.MessageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MessageServiceImpTest {
    @InjectMocks
    private MessageServiceImp messageServiceImp;
    @Mock
    private MessageRepository messageRepository;

    private Message createMessageForTest() {
        return Message.builder()
                .id(1)
                .senderId(1)
                .textMessage("test")
                .build();
    }

    @Test
    public void saveMessageTest() {
        Message message = createMessageForTest();
        when(messageRepository.save(message)).thenReturn(message);
        assertEquals(message, messageServiceImp.saveMessage(message));
    }

    @Test
    public void getHistoryMessage() {
        List<Message> messageListTest = new ArrayList<>();
        messageListTest.add(createMessageForTest());
        final Page<Message> page = new PageImpl<>(messageListTest);
        when(messageRepository.findAll(PageRequest.of(0, 10, Sort.Direction.DESC, "id"))).thenReturn(page);
        assertEquals(page, messageServiceImp.getHistoryMessages());
    }

}