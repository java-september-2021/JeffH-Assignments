package com.jeffh.overflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jeffh.overflow.models.Answer;
import com.jeffh.overflow.repositories.AnswerRepo;

@Service
public class AnswerService {
	private final AnswerRepo answerRepo;
	
	public AnswerService(AnswerRepo answerRepo) {
		this.answerRepo = answerRepo;
	}
	
	public List<Answer> allAnswers() {
		return answerRepo.findAll();
	}
	
    public Answer createAnswer(Answer b) {
        return answerRepo.save(b);
    }
}
