package com.Tamara.DojoOverflow1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Tamara.DojoOverflow1.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question,Long>{
	List<Question> findAll();
}
