package net.jay.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by wangjie on 5/10/14 3:02 PM.
 */

@Controller
public class HelloController {

    @RequestMapping("/accounts/{accountId}")
    public String hello(@PathVariable String accountId, Map<String, Object> he) {

        he.put("accountId", accountId);
        he.put("message", "Winter is coming");

        return "hello";
    }

    @RequestMapping("/")
    public String echo(Model model) {

        model.addAttribute("message", "Hello!");

        return "echo";
    }
}
