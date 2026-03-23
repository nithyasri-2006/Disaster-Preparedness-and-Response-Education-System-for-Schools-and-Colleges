package com.safecampus.safecampus.controller;

import com.safecampus.safecampus.model.AlertMessage;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminAlertController {

    private final SimpMessagingTemplate messagingTemplate;

    public AdminAlertController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @PostMapping("/broadcast")
    public String sendBroadcast(@RequestBody AlertMessage message) {

        messagingTemplate.convertAndSend("/topic/alerts", message);

        return "Alert Sent Successfully";
    }
}