package com.slv.qst.api;

import com.slv.qst.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/qustion")
public class AnswerController {
    private final AnswerService answerService;

    @PostMapping("/answer")
    private void answer(@RequestParam Long qst_id, @RequestParam String ans_emp_id, @RequestParam String title, @RequestParam String content) {
        answerService.answer(qst_id, ans_emp_id, title, content);
    }

}
