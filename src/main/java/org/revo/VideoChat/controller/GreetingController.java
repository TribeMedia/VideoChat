package org.revo.VideoChat.controller;

import org.revo.VideoChat.domain.uses.ConversationMessage;
import org.revo.VideoChat.domain.uses.Misc.MessageType;
import org.revo.VideoChat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class GreetingController {

    @Autowired
    SimpMessagingTemplate template;
    @Autowired
    MessageService messageService;

    @MessageMapping("/message")
    public void message(Principal principal, @Payload ConversationMessage message, SimpMessageHeaderAccessor header) {
        String sessionId = header.getSessionId();
        String name = principal.getName();
        if (message.getMessageType() != null) {
            if (message.getMessageType() == MessageType.INVITE_TO_PIPELINE_MESSAGE) {
                messageService.HandelINVITE_TO_PIPELINE_MESSAGE(message, sessionId, name);
            } else if (message.getMessageType() == MessageType.CREATE_PIPELINE_MESSAGE) {
                messageService.HandelCREATE_PIPELINE_MESSAGE(message, sessionId, name);
            } else if (message.getMessageType() == MessageType.JOIN_PIPELINE_MESSAGE) {
                messageService.HandelJOIN_PIPELINE_MESSAGE(message, sessionId, name);
            } else if(message.getMessageType()==MessageType.RELEASE_PIPELINE_MESSAGE){
                messageService.HandelRELEASE_PIPELINE_MESSAGE(message, sessionId, name);
            }
        }
    }
}
