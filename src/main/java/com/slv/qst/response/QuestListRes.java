package com.slv.qst.response;

import com.slv.qst.domain.question.Question;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@ApiModel("QuestListResponse")
public class QuestListRes {
    int questCnt;
    List<QuestRes> questResList;

    public static QuestListRes of(int questCnt, List<QuestRes> questResList){
        QuestListRes res = QuestListRes.builder()
            .questCnt(questCnt)
            .questResList(questResList)
            .build();
        return res;
    }
}
