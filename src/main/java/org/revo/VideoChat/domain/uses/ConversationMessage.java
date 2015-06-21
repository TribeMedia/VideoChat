package org.revo.VideoChat.domain.uses;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Created by ashraf on 6/10/15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConversationMessage implements Serializable {
    private Misc.MessageType messageType;
    private String content;
    private Misc.MediaPipelineType mediaPipelineType;
    private String from;
    private String to;

    public ConversationMessage() {
    }


    public ConversationMessage(Misc.MessageType messageType, String content, Misc.MediaPipelineType mediaPipelineType, String from, String to) {
        this.messageType = messageType;
        this.content = content;
        this.mediaPipelineType = mediaPipelineType;
        this.from = from;
        this.to = to;
    }

    public Misc.MessageType getMessageType() {
        return messageType;
    }

    public ConversationMessage setMessageType(Misc.MessageType messageType) {
        this.messageType = messageType;
        return this;
    }

    public String getFrom() {
        return from;
    }

    public ConversationMessage setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getTo() {
        return to;
    }

    public ConversationMessage setTo(String to) {
        this.to = to;
        return this;
    }

    public String getContent() {
        return content;
    }

    public ConversationMessage setContent(String content) {
        this.content = content;
        return this;
    }

    public Misc.MediaPipelineType getMediaPipelineType() {
        return mediaPipelineType;
    }

    public ConversationMessage setMediaPipelineType(Misc.MediaPipelineType mediaPipelineType) {
        this.mediaPipelineType = mediaPipelineType;
        return this;
    }
}
