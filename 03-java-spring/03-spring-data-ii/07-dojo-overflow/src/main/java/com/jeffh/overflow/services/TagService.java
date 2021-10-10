package com.jeffh.overflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jeffh.overflow.models.Tag;
import com.jeffh.overflow.repositories.TagRepo;

@Service
public class TagService {
	private final TagRepo tagRepo;
	
	public TagService(TagRepo tagRepo) {
		this.tagRepo = tagRepo;
	}
	
	public List<Tag> allTags() {
		return tagRepo.findAll();
	}
	
    public Tag createTag(Tag b) {
        return tagRepo.save(b);
    }
}
