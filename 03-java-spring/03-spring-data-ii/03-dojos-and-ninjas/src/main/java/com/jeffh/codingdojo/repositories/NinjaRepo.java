package com.jeffh.codingdojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jeffh.codingdojo.models.Dojo;
import com.jeffh.codingdojo.models.Ninja;

@Repository
public interface NinjaRepo extends  CrudRepository<Ninja, Long>{
	List<Ninja> findAll();
	
	List<Ninja> findNinjaByDojo(Dojo d);

}
