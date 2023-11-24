package com.slv.qst.request;

import lombok.Builder;
import lombok.Getter;
    
    
@Getter
public class QuestStatusPatchReq {
    Long qstId;
    int status;
}
    