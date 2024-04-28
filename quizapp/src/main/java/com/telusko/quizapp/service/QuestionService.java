package com.telusko.quizapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.quizapp.Dao.QuestionDao;

import com.telusko.quizapp.model.Question;

@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;
	public List<Question> getAllQuestion() {
		
		return questionDao.findAll();
		
	}
	public Optional<Question> getQuestionById(int id) {
		
		return questionDao.findById(id);
	}
	public void addQuestion(Question q) {
		
		questionDao.save(q);
		
	}

	
}
