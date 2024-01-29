package com.tweteroo.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.repositories.TweetRepository;

@Service
public class TweetService {
    
    final TweetRepository tweetRepository;

    TweetService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    public List<TweetModel> findAll() {
        return tweetRepository.findAll();
    }
}
