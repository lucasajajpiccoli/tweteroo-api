package com.tweteroo.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.services.TweetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tweets")
public class TweetController {

    final TweetService tweetService;

    TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }
    
    @GetMapping
    public ResponseEntity<List<TweetModel>> getTweets() {
        return ResponseEntity.status(HttpStatus.OK).body(tweetService.findAll());
    }

    @GetMapping("/user/{userId}")
    public String getTweetsByUserId() {
        return "Em implementação";
    }

    @PostMapping
    public ResponseEntity<Object> createTweet(@RequestBody @Valid TweetDTO body) {
        Optional<TweetModel> tweet = tweetService.save(body);

        if (!tweet.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user found for given userId");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(tweet.get());
    }
}
