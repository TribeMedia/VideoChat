package org.revo.VideoChat.service;

import org.revo.VideoChat.domain.user;

import java.util.List;

/**
 * Created by ashraf on 6/7/15.
 */
public interface userService {
    public user findByEmail(String email);

    public List<user> findAll();

    public user save(user user);
}