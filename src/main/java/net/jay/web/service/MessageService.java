package net.jay.web.service;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangjie on 5/16/14 12:38 AM.
 */

@Service
public class MessageService {

    private List<Message> msgList = new LinkedList<>();

    public List<Message> getMsgList() {
        return msgList;
    }

    public void addMessage(Message message) {
        msgList.add(message);
    }
}
