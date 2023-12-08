package com.twitter.timeline.infraestructure.repository.adapters;

import com.twitter.timeline.domain.timeline.Tweet;
import com.twitter.timeline.infraestructure.entites.TweetEntity;

public class TweetEntityAdapter {
    public static TweetEntity buildTweetEntityFromTweet(final Tweet tweet) {
        return TweetEntity.builder()
                .content(tweet.getContent())
                .publisherName(tweet.getPublisher())
                .dateCreated(tweet.getDateCreated())
                .build();
    }
}
