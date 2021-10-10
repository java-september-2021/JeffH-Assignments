package com.jeffh.overflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.jeffh.overflow.models.Tag;

public interface TagRepo extends CrudRepository<Tag, Long>{
	List<Tag> findAll();

	Optional<Tag> findBySubject(String subject);
}