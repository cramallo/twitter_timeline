package com.twitter.timeline.application;

import com.twitter.timeline.application.dto.TimeLineFoundDto;
import com.twitter.timeline.application.dto.TweetDto;
import com.twitter.timeline.domain.timeline.TimeLine;
import com.twitter.timeline.domain.timeline.Tweet;
import com.twitter.timeline.domain.timeline.TimelineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TimeLineService {

    private final FollowService followService;
    private final TimelineRepository timelineRepository;

    public void updateFollowersTimeLine(final TweetDto newTweetDto) {
        final var followers = followService.getFollowers(newTweetDto.getPublisher());

        followers.getFollowers()
                .parallelStream()
                .forEach(follower -> updateFollowersTimeLine(follower, newTweetDto));
    }

    public TimeLineFoundDto getTimeLine(final String userName,
                                        final int fromIndex) {

        return timelineRepository.findTimeLine(userName, fromIndex);
    }

    private void updateFollowersTimeLine(final String userName,
                                         final TweetDto tweetDto) {
        final var tweet = Tweet.builder()
                .publisher(tweetDto.getPublisher())
                .content(tweetDto.getContent())
                .dateCreated(tweetDto.getDateCreated())
                .build();

        timelineRepository.save(userName, tweet);
    }
}
