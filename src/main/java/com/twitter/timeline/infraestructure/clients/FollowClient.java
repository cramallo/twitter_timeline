package com.twitter.timeline.infraestructure.clients;

import com.twitter.timeline.domain.follow.FollowGateway;
import com.twitter.timeline.domain.follow.PageDomainFollow;
import com.twitter.timeline.infraestructure.clients.response.PageFollowResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.twitter.timeline.infraestructure.clients.adapter.PageFolllowAdapter.buildPageFollowFromResponse;
import static java.lang.String.format;

@Service
@AllArgsConstructor
public class FollowClient implements FollowGateway {

    private RestTemplate restTemplate;

    @Override
    // todo: implement pagination logic and remove hardcoded base_url
    public PageDomainFollow getFollowersByUsername(final String userName) {
        final var url = format("http://localhost:8080/follows/followers/%s?offset=%d", userName, 0);
        final var pageFollowResponse = restTemplate.getForObject(url, PageFollowResponse.class);
        return buildPageFollowFromResponse(pageFollowResponse);
    }
}
