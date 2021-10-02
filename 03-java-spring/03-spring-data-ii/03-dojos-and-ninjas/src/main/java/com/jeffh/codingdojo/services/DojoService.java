package com.jeffh.codingdojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jeffh.codingdojo.models.Dojo;
import com.jeffh.codingdojo.repositories.DojoRepo;

@Service
public class DojoService {
	private final DojoRepo dojoRepo;
	
	public DojoService(DojoRepo dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
    public List<Dojo> allDojos() {
        return dojoRepo.findAll();
    }

    public Dojo createDojo(Dojo b) {
        return dojoRepo.save(b);
    }
    
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepo.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }

}
