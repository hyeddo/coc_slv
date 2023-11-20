package com.slv.qst.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationProducer {
    private final KafkaTemplate kafkaTemplate;

    public void notifyQuest(Long qstId) {
        kafkaTemplate.send("quest-create", qstId);
    }

    public void notifyAnswer (Long ansId) {
        kafkaTemplate.send("answer-create", ansId);
    }
}
