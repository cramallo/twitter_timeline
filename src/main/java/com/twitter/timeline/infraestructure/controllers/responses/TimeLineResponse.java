package com.twitter.timeline.infraestructure.controllers.responses;


import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor
public class TimeLineResponse {
    String userName;
    List<TweetResponse> tweets;
    int lastIndex;
}
