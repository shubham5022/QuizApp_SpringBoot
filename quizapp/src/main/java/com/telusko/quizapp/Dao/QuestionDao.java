package com.telusko.quizapp.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telusko.quizapp.model.Question;

@Repository

public interface QuestionDao extends JpaRepository<Question,Integer>    {

	
	//@Query(value="SELECT * from question q where q.category=:category ORDER BY RANDOM() LIMIT :numQ",nativeQuery=true)
	@Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
	
	List<Question> findRandomQuestionsByCategory(String category, int numQ);

	
	

}
