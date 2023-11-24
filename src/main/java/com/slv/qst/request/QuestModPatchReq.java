package com.slv.qst.request;

import lombok.Getter;


@Getter
public class QuestModPatchReq {
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
}
