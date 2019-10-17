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

    /**
     * if a message is sent to /app/message then the streamMessage() method is called
     * the return value is broadcast to all subscribers to /topic/message
     * prefix /app and /topic is defined in configureMessageBroker() method in WebSocketConfig.class
     * @return message object -> value is set by saveMessage() method
     */
    @MessageMapping("/message")
    public MessageModel streamMessage() throws Exception {
        return message;
    }

    // get all previously sent messages
    @GetMapping("")
    public Iterator<MessageModel> getAllMessages() {
        return listMessages.iterator();
    }

    /*
    send message then save it to list
    message object is returned
    */
    @PostMapping("")
    public MessageModel saveMessage(MessageModel messageParam) {
        message = new MessageModel();
        message.setId(atomicInteger.getAndIncrement());
        message.setText(messageParam.getText());
        listMessages.add(message);

        return message;
    }
}
