package com.jeffh.overflow.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jeffh.overflow.models.Answer;
import com.jeffh.overflow.models.NewQuestion;
import com.jeffh.overflow.models.Question;
import com.jeffh.overflow.services.AnswerService;
import com.jeffh.overflow.services.QuestionService;
import com.jeffh.overflow.services.TagService;

@Controller
public class OverflowApi {
	private final QuestionService questionService;
	private final AnswerService answerService;
	private final TagService tagService;
    public OverflowApi(QuestionService questionService, AnswerService answerService, TagService tagService){
        this.questionService = questionService;
        this.answerService = answerService;
        this.tagService = tagService;
    }
    
    @RequestMapping("/")
    public String index(Model model) {
    	model.addAttribute("questions", questionService.allQuestions());
        return "index.jsp";
    }
    
	@GetMapping("/{id}")
	public String Show(@PathVariable("id") Long id, @ModelAttribute("ans") Answer ans, Model model) {
		model.addAttribute("question", questionService.findQuestion(id));
		return "question.jsp";
	}
    
    @RequestMapping("/quesiton/new")
    public String newQuestion(Model model) {
    	model.addAttribute("question", new Question());
        return "newQuestion.jsp";
    }
    
    @RequestMapping(value="/question/new", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("question") NewQuestion newQuestion, BindingResult result) {
        if (result.hasErrors()) {
            return "quesiton/newQuestion.jsp";
        } else {
            questionService.createQuestion(newQuestion);
            }
            return "redirect:/";
        }
    
    @RequestMapping(value="/newAnswer", method=RequestMethod.POST)
	public String createAnswer(@Valid @ModelAttribute("ans") Answer ans, BindingResult result) {
		if(result.hasErrors())
			return "question.jsp";
		answerService.createAnswer(ans);
		return "redirect:/" + ans.getQuestion().getId();
	}
}
