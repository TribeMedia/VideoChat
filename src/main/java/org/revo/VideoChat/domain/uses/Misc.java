package org.revo.VideoChat.domain.uses;

/**
 * Created by ashraf on 6/20/15.
 */
public class Misc {
    public enum UserType {
        Send, Receive, SendAndReceive
    }

    public enum MessageType {
        TEXT_MESSAGE,
        LOGOUT_MESSAGE,
        RELEASE_PIPELINE_MESSAGE,
        SDPOFFER_MESSAGE,
        INVITE_TO_PIPELINE_MESSAGE,
        ERROR,
        CREATE_PIPELINE_MESSAGE,
        JOIN_PIPELINE_MESSAGE
    }

    public enum MediaPipelineType {
        One_To_One, One_To_Many
    }


}
