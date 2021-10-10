package com.jeffh.overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jeffh.overflow.models.Answer;

public interface AnswerRepo extends CrudRepository<Answer, Long>{
	List<Answer> findAll();
}