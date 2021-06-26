package com.Tamara.DojoOverflow1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Tamara.DojoOverflow1.models.Answer;
import com.Tamara.DojoOverflow1.models.Question;
import com.Tamara.DojoOverflow1.models.Tag;
import com.Tamara.DojoOverflow1.repositories.AnswerRepository;
import com.Tamara.DojoOverflow1.repositories.QuestionRepository;
import com.Tamara.DojoOverflow1.repositories.TagRepository;

@Service
public class DojoOverflowService {
	private static final String Optinal = null;
	private final QuestionRepository questionRepository;
	private final AnswerRepository answerRepository;
	private final TagRepository tagRepository;

	public DojoOverflowService(QuestionRepository questionRepository, AnswerRepository answerRepository,
			TagRepository tagRepository) {
		this.questionRepository = questionRepository;
		this.answerRepository = answerRepository;
		this.tagRepository = tagRepository;
	}
	
	public List<Question> finaAllQuestions(){
		return this.questionRepository.findAll();
	}
	
	public Question createQuestion(Question question) {
		return this.questionRepository.save(question);
	}
	
	public Tag createTag(String tag) {
		Tag tags = new Tag(tag);
		return this.tagRepository.save(tags);
	}
	public boolean isNotCreated(String tag) {
		if(this.tagRepository.findBySubject(tag) == null) {
			return true;
		}
		return false;
	}
	
	public Tag getTag(String tag) {
		return this.tagRepository.findBySubject(tag);
	}
	
	public Answer createAnswer(Answer answer) {
		return this.answerRepository.save(answer);
	}
	
	public Question findQustionById(Long id) {
		Optional<Question> optionalQuestion = this.questionRepository.findById(id);
		if(optionalQuestion.isPresent()) {
			return optionalQuestion.get();
		}
		return null;
	}

	
}
