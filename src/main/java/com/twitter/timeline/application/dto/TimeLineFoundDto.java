package com.twitter.timeline.application.dto;

import com.twitter.timeline.domain.timeline.Tweet;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor
public class TimeLineFoundDto {
    String userName;
    List<Tweet> tweets;
    int lastIndex;
}
