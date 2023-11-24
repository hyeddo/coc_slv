package com.slv.qst.service;

import com.slv.qst.request.*;
import com.slv.qst.domain.question.Question;
import com.slv.qst.domain.question.QuestionRepository;
import com.slv.qst.producer.NotificationProducer;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import jakarta.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private NotificationProducer notificationProducer;

    public void registerQuest(QuestRegPostReq questRegPostReq){
        Question question = Question.builder()
                .title(questRegPostReq.getTitle())
                .content(questRegPostReq.getContent())
                .qstEmpId(questRegPostReq.getQstEmpId())
                .rspEmpId(questRegPostReq.getRspEmpId())
                .maincateId(questRegPostReq.getMaincateId())
                .midcateId(questRegPostReq.getMidcateId())
                .subcateId(questRegPostReq.getSubcateId())
                .maincateName(questRegPostReq.getMaincateId())
                .midcateName(questRegPostReq.getMidcateId())
                .subcateName(questRegPostReq.getSubcateId())
                .emergYn(questRegPostReq.getEmergYn())
                .questImage(questRegPostReq.getQuestImage())
                .status(1)
                .build();
        Question newQuestion = questionRepository.save(question);
        notificationProducer.notifyQuest(newQuestion.getQstId());
    }

    public void updateQuest(QuestModPatchReq questModPatchReq){
        Question question = Question.builder()
                .qstId(questModPatchReq.getQstId())
                .title(questModPatchReq.getTitle())
                .content(questModPatchReq.getContent())
                .qstEmpId(questModPatchReq.getQstEmpId())
                .rspEmpId(questModPatchReq.getRspEmpId())
                .maincateId(questModPatchReq.getMaincateId())
                .midcateId(questModPatchReq.getMidcateId())
                .subcateId(questModPatchReq.getSubcateId())
                .maincateName(questModPatchReq.getMaincateId())
                .midcateName(questModPatchReq.getMidcateId())
                .subcateName(questModPatchReq.getSubcateId())
                .emergYn(questModPatchReq.getEmergYn())
                .questImage(questModPatchReq.getQuestImage())
                .build();
        questionRepository.save(question);
    }

    public void updateStatus(QuestStatusPatchReq questStatusPatchReq){
        Question question = questionRepository.findById(questStatusPatchReq.getQstId());
        question.setStatus(questStatusPatchReq.getStatus);
        questionRepository.save(question);
    }

    public void updateEmployee(QuestEmpPatchReq questEmpPatchReq){
        Question question = questionRepository.findById(questEmpPatchReq.getQstId());
        question.setRspEmpId(questEmpPatchReq.getRspEmpId);
        questionRepository.save(question);
    }

    public void delete(Long qstId){
        questionRepository.deleteById(qstId);
    }

    public List<Question> getQuestList(){
        List<Question> result = questionRepository.findAllOrderByQstIdDesc();
        return result;
    }
    
    public List<Question> getQuestListByCate(Long mainCateId, Long midCateId, Long subCateId){
        List<Question> result = new ArrayList<>();
        if(mainCateId == 0){
            result = questionRepository.findAllOrderByQstIdDesc();
        } else if(midCateId == 0){
            result = questionRepository.findAllByMaincateIdOrderByQstIdDesc(mainCateId);
        } else if(subCateId == 0){
            result = questionRepository.findAllByMaincateIdAndMidcateIdOrderByQstIdDesc(mainCateId, midCateId);
        } else{
            result = questionRepository.findAllByMaincateIdAndMidcateIdAndSubcateIdOrderByQstIdDesc(mainCateId, midCateId, subCateId);
        }
        return result;
    }

    public List<Question> getQuestListByRsp(String rspEmpId){
        List<Question> result = questionRepository.findAllByRspEmpIdOrderByQstIdDesc(rspEmpId);
        return result;
    }

    public List<Question> getQuestListByQst(String qstEmpId){
        List<Question> result = questionRepository.findAllByQstEmpIdOrderByQstIdDesc(qstEmpId);
        return result;
    }

    public List<Question> getQuestListByEmpId(List<String> empList){
        List<Question> result = questionRepository.findAllByRspEmpIdInOrderByQstIdDesc(empList);
        return result;
    }

    public List<Question> getQuestListBySts(int status){
        List<Question> result = questionRepository.findAllByStatusOrderByQstIdDesc(status);
        return result;
    }
    public Question getQuestInfo(Long qstId){
        Question result = questionRepository.findOneByQstId(qstId);
        return result;
    }
}
