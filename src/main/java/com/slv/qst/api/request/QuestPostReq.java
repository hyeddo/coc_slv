package com.slv.qst.api.request;

import lombok.Getter;
import org.springframework.web.bind.annotation.RequestParam;

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
}
