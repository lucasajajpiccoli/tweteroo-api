package com.tweteroo.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.models.UserModel;

@Repository
public interface TweetRepository extends JpaRepository<TweetModel, Long> {
    
    List<TweetModel> findByUser(UserModel user);
}
