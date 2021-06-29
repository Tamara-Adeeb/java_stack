package com.Tamara.LoginRegistration.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.Tamara.LoginRegistration.models.User;
import com.Tamara.LoginRegistration.repositories.UserRepository;

@Service
public class ProjectService {
	private final UserRepository userRepository;

	public ProjectService(UserRepository userRepository) {
		this.userRepository = userRepository;
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
}
