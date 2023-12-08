package com.twitter.timeline.application;

import com.twitter.timeline.domain.follow.FollowGateway;
import com.twitter.timeline.domain.follow.PageDomainFollow;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FollowService {

    private FollowGateway followGateway;

    public PageDomainFollow getFollowers(final String userName) {
        return followGateway.getFollowersByUsername(userName);
    }

}
