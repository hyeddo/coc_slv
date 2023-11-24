package com.slv.qst.response;

import com.slv.qst.domain.question.Question;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@ApiModel("QuestResponse")
public class QuestRes {
    Long qstId;
    String title;
    String content;
    String qstEmpId;
    String rspEmpId;
    Long maincateId;
    Long midcateId;
    Long subcateId;
    String maincateName;
    String midcateName;
    String subcateName;
    String emergYn;
    String questImage;
    int status;

    public static QuestRes of(Question question){
        QuestRes res = QuestRes.builder()
            .qstId(question.getQstId())
            .title(question.getTitle())
            .content(question.getContent())
            .qstEmpId(question.getQstEmpId())
            .rspEmpId(question.getRspEmpId())
            .maincateId(question.getMaincateId())
            .midcateId(question.getMidcateId())
            .subcateId(question.getSubcateId())
            .maincateName(question.getMaincateId())
            .midcateName(question.getMidcateId())
            .subcateName(question.getSubcateId())
            .emergYn(question.getEmergYn())
            .questImage(question.getQuestImage())
            .status(question.getStatus())
            .build();
        return res;
    }
}
