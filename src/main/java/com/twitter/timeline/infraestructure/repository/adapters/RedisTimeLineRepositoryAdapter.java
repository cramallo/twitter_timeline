package com.twitter.timeline.infraestructure.repository.adapters;

import com.twitter.timeline.application.dto.TimeLineFoundDto;
import com.twitter.timeline.domain.timeline.TimeLine;
import com.twitter.timeline.domain.timeline.TimelineRepository;
import com.twitter.timeline.domain.timeline.Tweet;
import com.twitter.timeline.infraestructure.entites.TweetEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.twitter.timeline.infraestructure.repository.adapters.TimeLineAdapter.buildTimeLineFoundDtoFromTweetEntities;
import static com.twitter.timeline.infraestructure.repository.adapters.TweetEntityAdapter.buildTweetEntityFromTweet;

@Service
@AllArgsConstructor
@Slf4j
public class RedisTimeLineRepositoryAdapter implements TimelineRepository {

    private RedisTemplate<String, TweetEntity> redisTemplate;

    @Override
    public void save(final String userName, final Tweet tweet) {
        redisTemplate.opsForList().leftPush(userName, buildTweetEntityFromTweet(tweet));
    }

    @Override
    public TimeLineFoundDto findTimeLine(final String userName,
                                         final int fromIndex) {

        final List<TweetEntity> tweetEntities = redisTemplate.opsForList().range(
                userName,
                fromIndex,
                fromIndex + 100
        );

        return buildTimeLineFoundDtoFromTweetEntities(userName, tweetEntities, fromIndex + 100);
    }
}
