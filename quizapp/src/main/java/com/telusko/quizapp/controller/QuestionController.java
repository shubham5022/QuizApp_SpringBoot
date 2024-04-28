package com.telusko.quizapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.quizapp.model.Question;
import com.telusko.quizapp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired
	QuestionService questionService;
	@GetMapping("allQuestions")
	public List<Question> getAllQuestions() {
		
		return questionService.getAllQuestion();
		
	}
	
	@GetMapping("QuestionById/{id}")
	public Optional<Question> getQuestionById (@PathVariable int id) {
		
		return questionService.getQuestionById(id);
		
	}
	
	@PostMapping("addQuestions")
	
	public void addQuestion (@RequestBody   Question q) {
		questionService.addQuestion(q);
	}
	
	
}
