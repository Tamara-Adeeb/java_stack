package com.Tamara.LoginRegistration.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.Tamara.LoginRegistration.models.Course;
import com.Tamara.LoginRegistration.models.User;
import com.Tamara.LoginRegistration.models.UsersCourses;
import com.Tamara.LoginRegistration.repositories.CourseRepository;
import com.Tamara.LoginRegistration.repositories.UserRepository;
import com.Tamara.LoginRegistration.repositories.UsersCoursesRepository;

@Service
public class ProjectService {
	private final UserRepository userRepository;
	private final CourseRepository courseRepository;
	private final UsersCoursesRepository usersCoursesRepository;

	public ProjectService(UserRepository userRepository, CourseRepository courseRepository,
			UsersCoursesRepository usersCoursesRepository) {
		this.userRepository = userRepository;
		this.courseRepository = courseRepository;
		this.usersCoursesRepository = usersCoursesRepository;
	}
	
	public User userRegister(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
		return this.userRepository.save(user);
	}
	public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
	public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
	public Boolean authenticateRegister(String email) {
		User user = userRepository.findByEmail(email);
		if(user == null) {
            return true;
        }
		return false;
	}
	public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepository.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
	
	public List<Course> findAllCourses(){
		return this.courseRepository.findAll();
	}

	public Course findCourse(Long id) {
        Optional<Course> optionalCourse = this.courseRepository.findById(id);
        if(optionalCourse.isPresent()) {
            return optionalCourse.get();
        } else {
            return null;
        }
    }
	
	public Course createCourse(Course course) {
		return this.courseRepository.save(course);
	}
	
	public Course updateCourse(Course course) {
		return this.createCourse(course);
	}
	
	public Course addUserToCourse(User user, Course course) {
		course.addUser(user);
		int numSignup = course.getSignups();
		numSignup ++;
		course.setSignups(numSignup);
		return this.courseRepository.save(course);
	}
	public Course removeUserFromCourse(User user, Course course) {
		course.removeUser(user);
		int numSignup = course.getSignups();
		numSignup --;
		course.setSignups(numSignup);
		return this.courseRepository.save(course);
	}
	
	public void delete(Long id) {
		this.courseRepository.deleteById(id);
	}
	
	public List<UsersCourses> findAllJoinedUser(Course course){
		return this.usersCoursesRepository.findByCourse(course);
	}
	
}
