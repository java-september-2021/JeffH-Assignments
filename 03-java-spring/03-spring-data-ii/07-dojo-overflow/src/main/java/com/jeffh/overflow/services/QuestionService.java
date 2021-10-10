package com.jeffh.overflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jeffh.overflow.models.NewQuestion;
import com.jeffh.overflow.models.Question;
import com.jeffh.overflow.models.Tag;
import com.jeffh.overflow.repositories.QuestionRepo;
import com.jeffh.overflow.repositories.TagRepo;

@Service
public class QuestionService {
	private final QuestionRepo questionRepo;
	private final TagRepo tagRepo;
	
	public QuestionService(QuestionRepo questionRepo, TagRepo tagRepo) {
		this.questionRepo = questionRepo;
		this.tagRepo = tagRepo;
	}
	
	public List<Question> allQuestions() {
		return questionRepo.findAll();
	}
	
    public void createQuestion(NewQuestion b) {
    	List<Tag> questionTags = new ArrayList<Tag>();
		for(String subject: b.splitTags()) {
			Tag tag = this.tagRepo.findBySubject(subject).orElse(null);
			if(tag == null) {
				tag = new Tag(subject);
				this.tagRepo.save(tag);
			}
			if(!questionTags.contains(tag))
				questionTags.add(tag);
		}
		Question newQuestion = new Question(b.getQuestion(), questionTags);
        questionRepo.save(newQuestion);
    }
    
    public Question findQuestion(Long id) {
        Optional<Question> optionalQuestion = questionRepo.findById(id);
        if(optionalQuestion.isPresent()) {
            return optionalQuestion.get();
        } else {
            return null;
        }
    }
}
