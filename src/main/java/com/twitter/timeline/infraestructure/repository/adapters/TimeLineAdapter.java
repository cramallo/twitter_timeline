package com.twitter.timeline.infraestructure.repository.adapters;

import com.twitter.timeline.application.dto.TimeLineFoundDto;
import com.twitter.timeline.domain.timeline.TimeLine;
import com.twitter.timeline.domain.timeline.Tweet;
import com.twitter.timeline.infraestructure.entites.TweetEntity;

import java.util.List;

public class TimeLineAdapter {
    public static TimeLineFoundDto buildTimeLineFoundDtoFromTweetEntities(final String userName,
                                                                          final List<TweetEntity> tweetEntities,
                                                                          final int lastIndex) {
        final var tweets = tweetEntities.stream().map(
                tweetEntity -> new Tweet(
                        tweetEntity.getPublisherName(),
                        tweetEntity.getContent(),
                        tweetEntity.getDateCreated()
                )
        ).toList();

        return new TimeLineFoundDto(userName, tweets, lastIndex);
    }
}
