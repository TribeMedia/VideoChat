package org.revo.VideoChat.service.impl;

import org.revo.VideoChat.domain.user;
import org.revo.VideoChat.repositery.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by ashraf on 6/7/15.
 */
@Service
@Transactional
public class MyUserDetails implements UserDetailsService, SocialUserDetailsService {

    @Autowired
    userRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user byEmail = repository.findByEmail(username);
        return new User(byEmail.getEmail(), byEmail.getPassword(), byEmail.getAuthorities());
    }

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException, DataAccessException {
        return new MySocialUser(repository.findByEmail(userId));
    }

    public class MySocialUser implements SocialUserDetails {
        private user u;

        public MySocialUser(user u) {
            this.u = u;
        }

        @Override
        public String getUserId() {
            return u.getEmail();
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return u.getAuthorities();
        }

        @Override
        public String getPassword() {
            return u.getPassword();
        }

        @Override
        public String getUsername() {
            return u.getEmail();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
