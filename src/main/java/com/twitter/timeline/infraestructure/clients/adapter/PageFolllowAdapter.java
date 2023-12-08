package com.twitter.timeline.infraestructure.clients.adapter;

import com.twitter.timeline.domain.follow.PageDomainFollow;
import com.twitter.timeline.infraestructure.clients.response.FollowResponse;
import com.twitter.timeline.infraestructure.clients.response.PageFollowResponse;

import java.util.List;

public class PageFolllowAdapter {
    public static PageDomainFollow buildPageFollowFromResponse(final PageFollowResponse followResponse) {
        return PageDomainFollow.builder()
                .followers(getUserNames(followResponse.getData()))
                .total(followResponse.getTotal())
                .limit(followResponse.getLimit())
                .offset(followResponse.getOffset())
                .build();
    }

    private static List<String> getUserNames(final List<FollowResponse> followResponses) {
        return followResponses.stream()
                .map(FollowResponse::getFollower)
                .toList();
    }
}
