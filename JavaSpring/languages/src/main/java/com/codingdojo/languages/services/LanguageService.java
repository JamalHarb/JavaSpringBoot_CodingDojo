package com.codingdojo.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepo;
	public LanguageService(LanguageRepository languageRepo) {
		this.languageRepo = languageRepo;
	}
	public List<Language> findAllLanguages() {
		return languageRepo.findAll();
	}
	public Language createLanguage(Language language) {
		return languageRepo.save(language);
	}
	public boolean deleteLanguage(Long id) {
		languageRepo.deleteById(id);
		boolean isFound = languageRepo.existsById(id);
		return !isFound;
	}
	public Language updateLanguage(Language language) {
		return languageRepo.save(language);
	}
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepo.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		}
		else {
			return null;
		}
	}
}
