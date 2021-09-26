package com.jeffh.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jeffh.languages.models.Language;
import com.jeffh.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }

    public Language createLanguage(Language b) {
        return languageRepository.save(b);
    }
    
    public Language updateLanguage(Language b) {
        return languageRepository.save(b);
    }
    
    public void deleteLanguage(Long b) {
        languageRepository.deleteById(b);
    }
    
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
}
