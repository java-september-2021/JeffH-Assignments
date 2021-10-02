package com.jeffh.codingdojo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jeffh.codingdojo.models.Dojo;
import com.jeffh.codingdojo.models.Ninja;
import com.jeffh.codingdojo.repositories.NinjaRepo;

@Service
public class NinjaService {
	private final NinjaRepo ninjaRepo;
	
	public NinjaService(NinjaRepo ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
    public List<Ninja> allNinjas() {
        return ninjaRepo.findAll();
    }
    
    public List<Ninja> allNinjasByDojo(Dojo d) {
        return ninjaRepo.findNinjaByDojo(d);
    }

    public Ninja createNinja(Ninja b) {
        return ninjaRepo.save(b);
    }
    
}
