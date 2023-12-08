package com.twitter.timeline.infraestructure.controllers;

import com.twitter.timeline.application.TimeLineService;
import com.twitter.timeline.infraestructure.controllers.responses.TimeLineResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.twitter.timeline.infraestructure.controllers.responses.TimeLineResponseAdapter.buildTimeLineResponseFromDto;

@RestController
@RequestMapping("/timeline")
@AllArgsConstructor
public class TimeLineController {

    private TimeLineService timeLineService;

    @GetMapping
    public TimeLineResponse getTimeLine(@RequestHeader("user_name") final String userName,
                                        @RequestParam final int fromIndex) {

        final var timeLine = timeLineService.getTimeLine(userName, fromIndex);
        return buildTimeLineResponseFromDto(timeLine);
    }
}
