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
    private void answer(@RequestParam Long qstId, @RequestParam String ansEmpId, @RequestParam String title, @RequestParam String content) {
        answerService.answer(qstId, ansEmpId, title, content);
    }

}
