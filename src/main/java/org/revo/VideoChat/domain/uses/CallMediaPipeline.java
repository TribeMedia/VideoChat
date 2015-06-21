package org.revo.VideoChat.domain.uses;

import org.kurento.client.MediaPipeline;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ashraf on 6/9/15.
 */
public class CallMediaPipeline {
    private MediaPipeline MediaPipeline;
    private Misc.MediaPipelineType MediaPipelineType;
    private Set<userSession> sessions = new HashSet<>();

    public CallMediaPipeline() {
    }

    public CallMediaPipeline(MediaPipeline mediaPipeline, Misc.MediaPipelineType mediaPipelineType, userSession userSession) {
        this.MediaPipeline = mediaPipeline;
        this.MediaPipelineType = mediaPipelineType;
        this.sessions.add(userSession);
    }

    public MediaPipeline getMediaPipeline() {
        return MediaPipeline;
    }

    public CallMediaPipeline setMediaPipeline(MediaPipeline mediaPipeline) {
        MediaPipeline = mediaPipeline;
        return this;
    }

    public Misc.MediaPipelineType getMediaPipelineType() {
        return MediaPipelineType;
    }

    public CallMediaPipeline setMediaPipelineType(Misc.MediaPipelineType mediaPipelineType) {
        MediaPipelineType = mediaPipelineType;
        return this;
    }

    public Set<userSession> getSessions() {
        return sessions;
    }

    public CallMediaPipeline setSessions(Set<userSession> sessions) {
        this.sessions = sessions;
        return this;
    }

    public void AddUserSession(userSession userSession) {
        this.sessions.add(userSession);
    }

}
