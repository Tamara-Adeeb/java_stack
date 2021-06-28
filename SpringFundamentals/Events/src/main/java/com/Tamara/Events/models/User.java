package com.Tamara.Events.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import antlr.debug.Event;

@Entity
@Table(name="users")
public class User {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	@NotNull
	@Size(min=2,max=40)
	private String firstName;
	@NotNull
	@Size(min=2,max=40)
	private String lastName;
	@Email
	@NotNull
	private String email;
	private String location;
	private String[] state = {"CA","WA","AZ"};
	@NotNull
	@Size(min=8)
	private String password;
	@Transient
	private String passwordConfirmation;
	
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @OneToMany(mappedBy="host",fetch=FetchType.LAZY)
    private List<Event> Createdevents;
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
    		name="users_events",
    		joinColumns=@JoinColumn(name="user_id"),
    		inverseJoinColumns=@JoinColumn(name="event_id")
    		)
    private List<Event> joinedEvents;
    
//    @OneToMany(mappedBy="user")
//    private List<Comment> comments;
    
    
    
    
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
	

}
