package com.twitter.timeline.domain.follow;

import java.util.List;

public interface FollowGateway {
    PageDomainFollow getFollowersByUsername(String userName);
}
