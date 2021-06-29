package com.Tamara.Events.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.Tamara.Events.models.Comment;
import com.Tamara.Events.models.Event;
import com.Tamara.Events.models.User;
import com.Tamara.Events.repositories.CommentRepository;
import com.Tamara.Events.repositories.EventRepository;
import com.Tamara.Events.repositories.UserRepository;

@Service
public class EventsService {
	private final CommentRepository commentRepository;
	private final UserRepository userRepository;
	private final EventRepository eventRepository;
	public EventsService(CommentRepository commentRepository, UserRepository userRepository,
			EventRepository eventRepository) {
		this.commentRepository = commentRepository;
		this.userRepository = userRepository;
		this.eventRepository = eventRepository;
	}
	
	public Event createEvent(Event event) {
		return this.eventRepository.save(event);
	}
	
	public Event updateEvent(Event event) {
		return this.createEvent(event);
	}
	public Comment createComment(Comment comment) {
		return this.commentRepository.save(comment);
	}
	
	public Event FindEventById(Long id) {
		Optional<Event> optionalEvent = this.eventRepository.findById(id);
		if(optionalEvent.isPresent()) {
			return optionalEvent.get();
		}
		return null;
	}
	public User registerUser(User user) {
//		if(userRepository.findByEmail(user.getEmail()).isPresent()) {
//            result.rejectValue("email", "Unique", "This email is already in use!");
//        }
//        if(result.hasErrors()) {
//            return null;}
//        else {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
//        }
    }
	public List<Event> findAllEvent(){
		return this.eventRepository.findAll();
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
	// authenticate user
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
    
    public List<Event> findEventsInMyState(String state){
    	return this.eventRepository.findAllEventsByState(state);
    }
    
    public List<Event> finadEventByState(String state){
    	return this.eventRepository.findByState(state);
    }
    public List<Event> findEventNotInMyState(String state){
    	return this.eventRepository.findAllEventNotInState(state);
    }
	
}
