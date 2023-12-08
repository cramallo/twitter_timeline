package com.twitter.timeline.application.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.time.ZonedDateTime;

@Value
@AllArgsConstructor
public class TweetDto {
    String publisher;
    String content;
    ZonedDateTime dateCreated;
}
