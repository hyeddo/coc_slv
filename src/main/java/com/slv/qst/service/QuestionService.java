package com.slv.qst.service;

import com.slv.qst.api.request.QuestPostReq;
import com.slv.qst.domain.question.Question;
import com.slv.qst.domain.question.QuestionRepository;
import com.slv.qst.producer.NotificationProducer;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private NotificationProducer notificationProducer;

    @Transactional
    public void quest(QuestPostReq questPostReq){
//        Question question = Question.builder().
//                title()
//                .build();
//        Question newQuestion = questionRepository.save(question);
//        notificationProducer.notifyQuest(newQuestion.getQstId());
    }

    public void delete(Long qstId){
        questionRepository.deleteById(qstId);
//        log.info("{}번 문의 삭제", qstId);
    }
}
