package com.telusko.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusko.quizapp.Dao.QuestionDao;
import com.telusko.quizapp.Dao.QuizDao;
import com.telusko.quizapp.model.Question;
import com.telusko.quizapp.model.QuestionWrapper;
import com.telusko.quizapp.model.Quiz;

@Service
public class QuizService {

		@Autowired
		QuizDao quizdao;
		
		@Autowired
		QuestionDao questiondao;

		public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
			
			List<Question> questions= questiondao.findRandomQuestionsByCategory(category,numQ);
			Quiz quiz=new Quiz();
			
			quiz.setTitle(title);
			quiz.setQuestions(questions);
			quizdao.save(quiz);
			
			return new ResponseEntity<>("Success",HttpStatus.CREATED);
			
			
		}

		public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
			
			Optional <Quiz> quiz =quizdao.findById(id);
			
			List<Question> questionFromDB = quiz.get().getQuestions();
			
			List<QuestionWrapper> questionForUser = new ArrayList<>();
			
			for(Question q:questionFromDB ) {
				
				QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestion_title(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			
				questionForUser.add(qw);
				
			}
			
			return new ResponseEntity<>(questionForUser,HttpStatus.OK);
		}
		
		
	
}
