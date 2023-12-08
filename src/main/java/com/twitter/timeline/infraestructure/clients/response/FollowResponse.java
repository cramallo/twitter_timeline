package com.twitter.timeline.infraestructure.clients.response;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class FollowResponse {
    String follower;
    String followee;
}
