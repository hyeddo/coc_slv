package com.slv.qst.request;

import lombok.Builder;
import lombok.Getter;


@Getter
public class QuestPostReq {
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

             "emergYn” : string,
             “questImage” : multipart
}
