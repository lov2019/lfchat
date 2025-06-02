package com.gs2m22dg.lfchat;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.event.MouseWheelEvent;

@RestController
@RequestMapping("")
public class Routes {
    private Logger logger;
    private Message[] messages;
    public Routes() {
        this.logger = LoggerFactory.getLogger(Routes.class);
        this.messages = new Message[100];
        for (int i = 0; i < 100; i++) {
            this.messages[i] = null;
        }
    }
    @PostMapping("/sendmsg")
    public String sendmsg(HttpServletRequest request) {
        for (int i = 0; i < 99; i++) {
            this.messages[i] = this.messages[i + 1];
        }
        Message message = new Message();
        message.username = request.getParameter("username");
        message.message = request.getParameter("chatdata");
        this.messages[99] = message;
        this.logger.info("{} send {}", message.username, message.message);
        return "";
    }
    @GetMapping("/getmsg")
    public String getmsg() {
        StringBuilder rc = new StringBuilder();
        for (Message message : this.messages) {
            if (message == null) {
                continue;
            }
            rc.append("<strong>")
                    .append(LFChatTools.esHTML(message.username))
                    .append(":</strong><span>")
                    .append(LFChatTools.esHTML(message.message))
                    .append("</span><br>\n");
        }
        return rc.toString();
    }
}
