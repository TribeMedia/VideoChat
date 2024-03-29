package org.revo.VideoChat.service;

import org.revo.VideoChat.domain.db.user;

import java.util.List;
import java.util.Set;

/**
 * Created by ashraf on 6/9/15.
 */
public interface OnlineSession {
    public void CreateMediaPipeline(String MediaPipeline);

    public void CreateMediaPipeline(String MediaPipeline, Set<String> HaveAccess);

    public void CreateMediaPipeline(String MediaPipeline, String HaveAccess);

    public boolean AddUserToMediaPipeline(String MediaPipeline, String HaveAccess);

    public void AddUserToMediaPipeline(String MediaPipeline, Set<String> HaveAccess);

    public boolean IHaveAccessToMediaPipeline(String MediaPipeline, String ME);

    public Set<String> WhatMediaPipelineICanAccess(String me);

    public void RemoveMediaPipeline(String MediaPipeline);

    public void AddOnlineUser(String name, String simpSessionId);

    public void RemoveOnlineUser(String name);

    public Set<String> UserSessions(String name);

    public void UpdateOne(String name, Set<String> s);

    public void PersonState(Boolean Sate, String name, String simpSessionId);

    public void Notify(List<user> personList, String group, String user);
}
