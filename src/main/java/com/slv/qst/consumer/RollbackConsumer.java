package com.slv.qst.consumer;

import com.slv.qst.service.AnswerService;
import com.slv.qst.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RollbackConsumer {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;

    // TODO: group명 변경 필요
    @KafkaListener(topics = "quest-rollback", groupId = "group-01")
    public void rollbackQuest(Long qstId){
        questionService.delete(qstId);
    }
    @KafkaListener(topics = "answer-rollback", groupId = "group-01")
    public void rollbackAnswer(Long ansId){
        answerService.delete(ansId);
    }
}
