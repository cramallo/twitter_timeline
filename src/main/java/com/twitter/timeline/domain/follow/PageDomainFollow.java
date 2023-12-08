package com.twitter.timeline.domain.follow;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class PageDomainFollow {
    List<String> followers;
    long offset;
    int total;
    int limit;
}
