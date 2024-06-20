package org.example.messageboard.controller;

import org.example.messageboard.model.MessageInfo;
import org.example.messageboard.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-09
 * Time: 1:22
 */
@RestController
@RequestMapping("/board")
public class MessageBoardController {
    @Autowired
    private MessageService messageService;

    @RequestMapping("/setMessage")
    public boolean setMessage(MessageInfo message) {
        return messageService.insertMessage(message);
    }
    @RequestMapping("/getMessage")
    public ArrayList<MessageInfo> getMessage() {
        return messageService.selectAllMessage();
    }
}
