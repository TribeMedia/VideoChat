package org.revo.VideoChat.service;

import org.revo.VideoChat.domain.ConversationMessage;

/**
 * Created by ashraf on 6/11/15.
 */
public interface MessageService {

    public void HandelINVITE_TO_PIPELINE_MESSAGE(ConversationMessage message, String sessionId, String name);

    public void HandelCREATE_PIPELINE_MESSAGE(ConversationMessage message, String sessionId, String name);

    public void HandelJOIN_PIPELINE_MESSAGE(ConversationMessage message, String sessionId, String name);

    public void HandelRELEASE_PIPELINE_MESSAGE(ConversationMessage message, String sessionId, String name);
}
