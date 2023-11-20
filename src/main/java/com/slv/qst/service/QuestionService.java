package com.slv.qst.service;

import com.slv.qst.domain.question.Question;
import com.slv.qst.domain.question.QuestionRepository;
import com.slv.qst.producer.NotificationProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final NotificationProducer notificationProducer;

    public void quest(String title, String content, String qstEmpId, String rspEmpId, Long maincateId, Long midCateId, Long subcateId, String maincateName, String midcateName, String subcateName){
        final Question question = new Question(title, content, qstEmpId, rspEmpId, maincateId, midCateId, subcateId, maincateName, midcateName, subcateName);
        final Question newQuestion = questionRepository.save(question);
        notificationProducer.notifyQuest(newQuestion.getQstId());
    }

    public void delete(Long qstId){
        questionRepository.deleteById(qstId);
        log.info("{}번 문의 삭제", qstId);
    }
}
