package com.twitter.timeline.infraestructure.controllers.responses;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.time.ZonedDateTime;

@Value
@AllArgsConstructor
public class TweetResponse {
    String publisherName;
    String content;
    ZonedDateTime dateCreated;
}
