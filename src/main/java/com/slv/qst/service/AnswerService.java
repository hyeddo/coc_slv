package com.slv.qst.service;

import com.slv.qst.domain.answer.Answer;
import com.slv.qst.domain.answer.AnswerRepository;
import com.slv.qst.producer.NotificationProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final NotificationProducer notificationProducer;

    public void answer(Long qst_id, String ans_emp_id, String title, String content){
        final Answer answer = new Answer(qst_id, ans_emp_id, title, content);
        final Answer newAnswer = answerRepository.save(answer);
        notificationProducer.notifyAnswer(newAnswer.getAns_id());
    }

    public void delete(Long ansId){
        answerRepository.deleteById(ansId);
        log.info("{}번 답변 삭제", ansId);
    }
}
