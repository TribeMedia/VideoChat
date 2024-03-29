package org.revo.VideoChat.repositery;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.revo.VideoChat.domain.db.user;

import java.util.List;

/**
 * Created by ashraf on 6/7/15.
 */
public interface userRepository extends CrudRepository<user, Long> {
    public user findByEmail(String email);

    @Query("select u from user u")
    public List<user> findall();
}
