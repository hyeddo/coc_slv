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

    public void quest(String title, String content, String qst_emp_id, String rsp_emp_id, Long maincate_id, Long midcate_id, Long subcate_id, String maincate_name, String midcate_name, String subcate_name){
        final Question question = new Question(title, content, qst_emp_id, rsp_emp_id, maincate_id, midcate_id, subcate_id, maincate_name, midcate_name, subcate_name);
        final Question newQuestion = questionRepository.save(question);
        notificationProducer.notifyQuest(newQuestion.getQst_id());
    }

    public void delete(Long qstId){
        questionRepository.deleteById(qstId);
        log.info("{}번 문의 삭제", qstId);
    }
}
