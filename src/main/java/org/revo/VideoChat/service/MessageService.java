package org.revo.VideoChat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.revo.VideoChat.messages.ConversationMessage;

/**
 * Created by ashraf on 6/11/15.
 */
public interface MessageService {

    public void HandelINVITE_TO_PIPELINE_MESSAGE(ConversationMessage message, String sessionId, String name);

    public void HandelCREATE_PIPELINE_MESSAGE(ConversationMessage message, String sessionId, String name);

    public void HandelJOIN_PIPELINE_MESSAGE(ConversationMessage message, String sessionId, String name);

    public void HandelRELEASE_PIPELINE_MESSAGE(ConversationMessage message, String sessionId, String name);
}
