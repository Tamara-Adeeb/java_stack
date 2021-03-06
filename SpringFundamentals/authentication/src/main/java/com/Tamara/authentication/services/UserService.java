package com.Tamara.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.Tamara.authentication.models.User;
import com.Tamara.authentication.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return this.userRepository.save(user);
	}
	
	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}
	public User findUserById(Long id) {
    	Optional<User> userOptional = userRepository.findById(id);
    	if(userOptional.isPresent()) {
            return userOptional.get();
    	} else {
    	    return null;
    	}
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
