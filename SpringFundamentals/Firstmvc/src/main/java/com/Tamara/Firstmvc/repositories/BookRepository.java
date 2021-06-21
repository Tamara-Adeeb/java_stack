package com.Tamara.Firstmvc.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.Tamara.Firstmvc.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	//there is some  Queries that i can use in the service without put them here 
	List<Book> findAll();
	Optional<Book> findById(Long id);
	void deleteById(Long id);
	boolean existsById(Long id);
}
