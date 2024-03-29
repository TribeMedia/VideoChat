package org.revo.VideoChat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.security.Principal;
import java.util.Set;

/**
 * Created by ashraf on 6/9/15.
 */
public class PresenceEventListener implements ApplicationListener<ApplicationEvent> {
    @Autowired
    SimpMessagingTemplate template;
    @Autowired
    OnlineSession onlineSession;
    @Autowired
    MediaPipelineService pipelineService;

    private void handleSessionConnected(SessionConnectEvent event) {
        final Principal principal = SimpMessageHeaderAccessor.getUser(event.getMessage().getHeaders());
        final String simpSessionId = SimpMessageHeaderAccessor.getSessionId(event.getMessage().getHeaders());
        final Set<String> s = onlineSession.UserSessions(principal.getName());
        if (s == null) {
            onlineSession.PersonState(true, principal.getName(), simpSessionId);
//            onlineSession.Notfiy(ser.MyonlineFrindes(principal.getName()), "online", principal.getName());
        } else {
            s.add(simpSessionId);
            onlineSession.UpdateOne(principal.getName(), s);
        }

    }

    private void handleSessionDisconnect(SessionDisconnectEvent event) {
        final Principal principal = SimpMessageHeaderAccessor.getUser(event.getMessage().getHeaders());
        final String simpSessionId = SimpMessageHeaderAccessor.getSessionId(event.getMessage().getHeaders());
        final Set<String> s = onlineSession.UserSessions(principal.getName());

        if (s.size() > 1) {
            s.remove(simpSessionId);
            pipelineService.SomeOneRemoveSessionCheckHim(simpSessionId);
            onlineSession.UpdateOne(principal.getName(), s);
        } else {
            pipelineService.SomeOneRemoveSessionCheckHim(simpSessionId);
            new Thread(() -> {
                try {
                    Thread.sleep(10000);
                    Set<String> s1 = onlineSession.UserSessions(principal.getName());
                    if (s1!=null&&s1.size() == 1) {
//                            onlineSession.Notfiy(ser.MyonlineFrindes(principal.getName()), "offline", principal.getName());
                        onlineSession.PersonState(false, principal.getName(), "");
                    } else {
                        s.remove(simpSessionId);
                        onlineSession.UpdateOne(principal.getName(), s);
                    }
                } catch (InterruptedException e) {
                }
            }).start();

        }

    }


    public void onApplicationEvent(ApplicationEvent event) {

        if (event instanceof SessionConnectEvent) {
            handleSessionConnected((SessionConnectEvent) event);
        } else if (event instanceof SessionDisconnectEvent) {
            handleSessionDisconnect((SessionDisconnectEvent) event);
        }
    }
}
