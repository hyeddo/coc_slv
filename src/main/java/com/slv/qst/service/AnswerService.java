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

    public void answer(Long qstId, String ansEmpId, String title, String content){
        final Answer answer = new Answer(qstId, ansEmpId, title, content);
        final Answer newAnswer = answerRepository.save(answer);
        notificationProducer.notifyAnswer(newAnswer.getAnsId());
    }

    public void delete(Long ansId){
        answerRepository.deleteById(ansId);
        log.info("{}번 답변 삭제", ansId);
    }
}
