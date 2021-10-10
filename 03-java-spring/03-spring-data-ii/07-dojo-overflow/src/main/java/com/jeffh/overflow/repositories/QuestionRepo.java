package com.jeffh.overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jeffh.overflow.models.Question;

public interface QuestionRepo extends CrudRepository<Question, Long>{
	List<Question> findAll();
}
