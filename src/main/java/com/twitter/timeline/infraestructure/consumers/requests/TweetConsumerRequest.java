package com.twitter.timeline.infraestructure.consumers.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TweetConsumerRequest implements Serializable {
    private Long id;
    private String userName;
    private String content;
    private ZonedDateTime dateCreated;
}
