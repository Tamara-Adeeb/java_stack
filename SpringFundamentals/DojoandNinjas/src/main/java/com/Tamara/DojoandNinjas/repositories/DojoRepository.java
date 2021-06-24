package com.Tamara.DojoandNinjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Tamara.DojoandNinjas.models.Dojo;
import com.Tamara.DojoandNinjas.models.Ninja;

@Repository
public interface DojoRepository extends CrudRepository <Dojo,Long> {
	List<Dojo> findAll();

//	int count(Ninja ninja);

}
