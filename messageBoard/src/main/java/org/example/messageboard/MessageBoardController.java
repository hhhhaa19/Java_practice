package org.example.messageboard;

import ch.qos.logback.core.util.StringUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
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
    private ArrayList<MessageInfo> messages = new ArrayList<MessageInfo>();

    @RequestMapping("/setMessage")
    public boolean setMessage(MessageInfo message) {
        if (!StringUtils.hasLength(message.getMessage())
                || !StringUtils.hasLength(message.getDestination()) ||
                !StringUtils.hasLength(message.getSource())) {
            return false;
        }
        messages.add(message);
        return true;
    }
    @RequestMapping("/getMessage")
    public ArrayList<MessageInfo> getMessage() {
        return messages;
    }
}
