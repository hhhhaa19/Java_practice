package org.example.messageboard;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-09
 * Time: 1:21
 */
@Data
public class MessageInfo {
    private String source;
    private String destination;
    private String message;
}
