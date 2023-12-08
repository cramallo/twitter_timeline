package com.twitter.timeline.infraestructure.clients.response;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor
public class PageFollowResponse {
    List<FollowResponse> data;
    long offset;
    int total;
    int limit;
}
