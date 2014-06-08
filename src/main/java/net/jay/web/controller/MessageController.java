package net.jay.web.controller;

import net.jay.web.service.Message;
import net.jay.web.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by wangjie on 5/16/14 12:44 AM.
 */

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping("/form")
    public String form() {
        return "form";
    }

    @RequestMapping("/form-submit")
    public String formSubmit(@RequestParam String from, @RequestParam String to, @RequestParam String msg) {

        Message message = new Message();
        message.setFrom(from);
        message.setTo(to);
        message.setMsg(msg);

        messageService.addMessage(message);

        return "redirect:/list-messages";
    }

    @RequestMapping("/list-messages")
    public String listMessages(Model model) {

        model.addAttribute("beanList", messageService.getMsgList());

        return "msgList";
    }
}
