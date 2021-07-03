package com.Tamara.auth.models;

import java.util.ArrayList;
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
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
@Table(name="users")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotNull
	@Size(min=2,max=40,message="First Name must be between 2-40 characters.")
	private String firstName;
	@NotNull
	@Size(min=2,max=40,message="Last Name must be between 2-40 characters.")
	private String lastName;
	@Email
	private String email;
	@Min(13)
	private int age;
	@Size(min=8,max=64,message="password must be between 8-64 characters.")
	private String password;
	@Transient
	@Size(min=8,max=64,message="password must be between 8-64 characters.")
	private String passwordConfirmation;
	
	private String photos;
	
//	private List<String> games;;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    //self join for friednshipe relationship
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "friendships", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private List<User> friends;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "friendships", 
        joinColumns = @JoinColumn(name = "friend_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> userFriends;
    
    //many to many with role table
    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;
    
    //one to many with post table
    @OneToMany(mappedBy="user",fetch=FetchType.LAZY)
    private List<Post> posts;
    
    //one to many with comment table
    @OneToMany(mappedBy="user",fetch=FetchType.LAZY)
    private List<Comment> comments;
    
    //one to many with reply table
    @OneToMany(mappedBy="user",fetch=FetchType.LAZY)
    private List<Reply> replies;
    
    //one to many with message table
    @OneToMany(mappedBy="user",fetch=FetchType.LAZY)
    private List<Message> messages;
    
    //many to many with game Table
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
    		name="users_games",
    		joinColumns = @JoinColumn(name = "user_id"), 
    		inverseJoinColumns = @JoinColumn(name = "game_id")
    		)
    private List<Game> games;
    
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
