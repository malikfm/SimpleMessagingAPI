package com.malik.SimpleMessagingAPI.controller;

import com.malik.SimpleMessagingAPI.model.MessageModel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/message")
public class MessageController {

    // auto-increment id
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private MessageModel message;
    private List<MessageModel> listMessages = new ArrayList<>();

    @MessageMapping("/message")
    public MessageModel streamMessage() throws Exception {
        Thread.sleep(300); // simulated delay
        return message;
    }

    @GetMapping("")
    public Iterator<MessageModel> getAllMessages() {
        return listMessages.iterator();
    }

    @PostMapping("")
    public MessageModel saveMessage(MessageModel messageParam) {
        message = new MessageModel();
        message.setId(atomicInteger.getAndIncrement());
        message.setText(messageParam.getText());
        listMessages.add(message);


        return message;
    }
}
