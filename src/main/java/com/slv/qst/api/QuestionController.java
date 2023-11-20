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
    private void quest(@RequestParam String title, @RequestParam String content, @RequestParam String qst_emp_id, @RequestParam String rsp_emp_id, @RequestParam Long maincate_id, @RequestParam Long midcate_id, @RequestParam Long subcate_id, @RequestParam String maincate_name, @RequestParam String midcate_name, @RequestParam String subcate_name) {
        questionService.quest(title, content, qst_emp_id, rsp_emp_id, maincate_id, midcate_id, subcate_id, maincate_name, midcate_name, subcate_name);
    }

}
