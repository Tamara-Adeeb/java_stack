package com.Tamara.LoginRegistration.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Tamara.LoginRegistration.models.Course;
import com.Tamara.LoginRegistration.models.UsersCourses;

@Repository
public interface UsersCoursesRepository extends CrudRepository<UsersCourses,Long>{
	List<UsersCourses> findByCourse(Course course);
}
