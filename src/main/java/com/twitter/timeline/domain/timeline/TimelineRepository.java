package com.twitter.timeline.domain.timeline;

import com.twitter.timeline.application.dto.TimeLineFoundDto;

import java.util.List;

public interface TimelineRepository {
    void save(String userName, Tweet tweet);

    TimeLineFoundDto findTimeLine(String userName, int fromIndex);
}
