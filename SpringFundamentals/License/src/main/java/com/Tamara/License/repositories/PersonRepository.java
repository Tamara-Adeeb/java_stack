package com.Tamara.License.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Tamara.License.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long>{
	List<Person> findAll();
	List<Person> findByLiscensesIdIsNull();
}
