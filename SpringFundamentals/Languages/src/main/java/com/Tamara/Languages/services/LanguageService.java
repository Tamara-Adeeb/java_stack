package com.Tamara.Languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Tamara.Languages.models.Language;
import com.Tamara.Languages.repositories.LanguageRepository;
@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	public List<Language> allLanguages(){
		return this.languageRepository.findAll();
	}
	
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage= this.languageRepository.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		}else {
		return null;
		}
	}
	public Language createLanguage(Language language) {
		return languageRepository.save(language);
	}
	public Language updateLanguage(Language language) {
		return this.createLanguage(language);
	}
	
	public void deleteLanguage(Long id) {
		this.languageRepository.deleteById(id);
	}
}


