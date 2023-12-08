package com.twitter.timeline.infraestructure.controllers.responses;

import com.twitter.timeline.application.dto.TimeLineFoundDto;
import com.twitter.timeline.domain.timeline.Tweet;

import java.util.List;

public class TimeLineResponseAdapter {

    public static TimeLineResponse buildTimeLineResponseFromDto(final TimeLineFoundDto timeLineDto) {
        return new TimeLineResponse(
                timeLineDto.getUserName(),
                buildTweetResponsseFromTweets(timeLineDto.getTweets()),
                timeLineDto.getLastIndex()
        );
    }

    private static List<TweetResponse> buildTweetResponsseFromTweets(final List<Tweet> tweets) {
        return tweets.stream().map(tweet -> new TweetResponse(
                tweet.getPublisher(),
                tweet.getContent(),
                tweet.getDateCreated())
        ).toList();
    }
}
