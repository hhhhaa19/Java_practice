package org.example.messageboard.service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.example.messageboard.mapper.MessageMapper;
import org.example.messageboard.model.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-21
 * Time: 0:12
 */
@Slf4j
@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;

    public Boolean insertMessage(MessageInfo message) {
        log.info("insertMessage");
        log.info("message: {}", message);
        if (!StringUtils.hasLength(message.getFrom())||
                !StringUtils.hasLength(message.getTo())||
                !StringUtils.hasLength(message.getMessage())){
            return false;
        }
        Integer i = messageMapper.insertMessage(message);
        if (i >= 1){
            return true;
        }
        return false;
    }

    public ArrayList<MessageInfo> selectAllMessage() {
        return messageMapper.selectAllMessage();
    }
}
