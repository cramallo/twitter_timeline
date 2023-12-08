package com.twitter.timeline.infraestructure.entites;


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
public class TweetEntity implements Serializable {
    private String publisherName;
    private String content;
    private ZonedDateTime dateCreated;
}
