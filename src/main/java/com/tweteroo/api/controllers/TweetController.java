package com.tweteroo.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.services.TweetService;

@RestController
@RequestMapping("/tweets")
public class TweetController {

    final TweetService tweetService;

    TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }
    
    @GetMapping
    public List<TweetModel> getTweets() {
        return tweetService.findAll();
    }

    @GetMapping("/user/{userId}")
    public String getTweetsByUserId() {
        return "Em implementação";
    }

    @PostMapping
    public String createTweet() {
        return "Em implementação";
    }
}
