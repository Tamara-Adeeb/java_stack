package com.Tamara.DojoOverflow1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Tamara.DojoOverflow1.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag,Long>{
	List<Tag> findAll();
//	Tag findByTag(Tag tag);
	Tag findBySubject(Tag tag);
	Tag findBySubject(String tag);
	Tag save(String tag);
}
