package com.twitter.timeline.domain.timeline;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.ZonedDateTime;

@Value
@Builder
@AllArgsConstructor
public class Tweet {
    String publisher;
    String content;
    ZonedDateTime dateCreated;
}
