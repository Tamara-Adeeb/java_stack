package com.Tamara.DojoOverflow1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Tamara.DojoOverflow1.models.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer,Long>{
	List<Answer> findAll();
}
