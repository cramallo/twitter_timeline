package com.twitter.timeline.infraestructure.consumers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twitter.timeline.application.TimeLineService;
import com.twitter.timeline.application.dto.TweetDto;
import com.twitter.timeline.infraestructure.consumers.requests.TweetConsumerRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class TweetConsumer {

    private final TimeLineService timeLineService;
    private ObjectMapper objectMapper;

    @RabbitListener(queues = {"tweet-events-queue"})
    public void consumer(@Payload Message message) {

        final var tweetConsumerRequest = buildTweetConsumerRequestFromMessage(message);

        log.info("Received message: {}", tweetConsumerRequest);

        try {
            timeLineService.updateFollowersTimeLine(
                    new TweetDto(
                            tweetConsumerRequest.getUserName(),
                            tweetConsumerRequest.getContent(),
                            tweetConsumerRequest.getDateCreated()
                    )
            );
        } catch (Exception e) {
            log.error("Exception processing new");
            throw e;
        }
    }

    private TweetConsumerRequest buildTweetConsumerRequestFromMessage(final Message message) {
        try {
            final String jsonString = new String(message.getBody(), "UTF-8");
            return objectMapper.readValue(jsonString, TweetConsumerRequest.class);
        } catch (Exception e) {
            log.error("Error converting TweetEntity: {}", e.getMessage(), e);
            throw new RuntimeException("Error converting TweetEntity");
        }
    }
}

