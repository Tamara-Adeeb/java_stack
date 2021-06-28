package com.Tamara.authentication.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Tamara.authentication.models.User;

@Repository
public interface UserRepository extends CrudRepository <User,Long> {
	//Why i did not use optional in case of email only the id ???
	User findByEmail(String email);

}
