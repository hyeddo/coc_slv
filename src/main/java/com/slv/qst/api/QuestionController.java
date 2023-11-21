package com.slv.qst.api;

import com.slv.qst.api.request.QuestPostReq;
import com.slv.qst.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/qustion")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("/quest")
    private void registerQuest(QuestPostReq questPostReq) {
        questionService.quest(questPostReq);
    }

}
