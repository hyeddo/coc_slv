package com.slv.qst.api;

import com.slv.qst.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/qustion")
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping("/quest")
    private void quest(@RequestParam String title, @RequestParam String content, @RequestParam String qstEmpId, @RequestParam String rspEmpId, @RequestParam Long maincateId, @RequestParam Long midcateId, @RequestParam Long subcateId, @RequestParam String maincateName, @RequestParam String midcateName, @RequestParam String subcateName) {
        questionService.quest(title, content, qstEmpId, rspEmpId, maincateId, midcateId, subcateId, maincateName, midcateName, subcateName);
    }

}
