package com.safecampus.safecampus.controller;

import com.safecampus.safecampus.model.AlertMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class AlertWebSocketController {

    @MessageMapping("/alert")
    @SendTo("/topic/alerts")
    public AlertMessage sendAlert(AlertMessage message) {
        return message;
    }
}