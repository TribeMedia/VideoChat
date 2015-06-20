package org.revo.VideoChat.service;

import org.revo.VideoChat.domain.CallMediaPipeline;
import org.revo.VideoChat.domain.CallMediaPipeline.MediaPipelineType;
import org.revo.VideoChat.domain.userSession;

import java.util.List;

/**
 * Created by ashraf on 6/10/15.
 */
public interface MediaPipelineService {

    public void CreatePipeline(MediaPipelineType mediaPipelineType, userSession sessions, String sdpOffer);

    public void addUserToPipeline(String NameOfCreatorOfPipeline, userSession userSession, String sdpOffer);

    public void ReleasePipelineUsingNameOfCreatorOfPipeline(String NameOfCreatorOfPipeline);

    public void ReleasePipelineUsingSessionId(CallMediaPipeline CallMediaPipeline, List<userSession> collect, String simpSessionId);

    public boolean HaveOrInMediaPipeline(String Name);

    public CallMediaPipeline getCallMediaPipeline(String Creator);

    void SomeOneRemoveSessionCheckHim(String simpSessionId);
}
