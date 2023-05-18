package com.ll.sbbtest0518.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;
    @GetMapping("/question/list")
    public String getList(Model model){
        List<Question> questionList = questionService.getList();
        model.addAttribute(questionList);
        return "question_list";
    }

    @GetMapping("/question/detail/{id}")
    public String questionDetail(Model model, @PathVariable("id") Integer id){
        Question question = questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    @GetMapping("/question/create")
    public String questionCreate(){
        return "question_form";
    }

    @PostMapping("/question/create")
    public String questionCreate2(String title, String content){
        questionService.create(title, content);
        return "redirect:/question/list";
    }
}
