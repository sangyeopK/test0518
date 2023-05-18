package com.ll.sbbtest0518.answer;

import com.ll.sbbtest0518.question.Question;
import com.ll.sbbtest0518.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;


@Controller
@RequiredArgsConstructor
public class AnswerController {
    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/answer/create/{id}")
    public String answer(Question question, String content, @PathVariable("id") Integer id){
        answerService.createAnswer(question, content);
        return String.format("redirect:/question/detail/%s", id);
    }
}
