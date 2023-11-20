package com.slv.qst.consumer;

import com.slv.qst.service.AnswerService;
import com.slv.qst.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RollbackConsumer {
    private final QuestionService questionService;
    private final AnswerService answerService;

    // TODO: group명 변경 필요
    @KafkaListener(topics = "quest-rollback", groupId = "group-01")
    public void rollbackQuest(Long qstId){
        log.error("======== [Rollback] quest-rollback, qstId :{}======== ", qstId);
        questionService.delete(qstId);
    }
    @KafkaListener(topics = "answer-rollback", groupId = "group-01")
    public void rollbackAnswer(Long ansId){
        log.error("======== [Rollback] answer-rollback, ansId :{}======== ", ansId);
        answerService.delete(ansId);
    }
}
