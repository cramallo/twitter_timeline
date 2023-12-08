package com.twitter.timeline.domain.timeline;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor
public class TimeLine {
    String user;
    List<Tweet> tweets;
}
