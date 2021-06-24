package com.Tamara.License.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Tamara.License.models.Licenses;


@Repository
public interface LicenseRepository extends CrudRepository<Licenses,Long> {

	
	List<Licenses> findAll();
	Licenses findTopByOrderByNumberDesc();

	
}
