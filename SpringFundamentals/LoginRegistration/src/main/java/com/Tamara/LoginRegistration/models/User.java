package com.Tamara.LoginRegistration.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Size(min=2,max=40,message="First Name must be between 2-40 characters.")
	private String firstName;
	@Size(min=2,max=40,message="Last Name must be between 2-40 characters.")
	private String lastName;
	@Email
	private String email;
	@Size(min=8,max=64,message="password must be between 8-64 characters.")
	private String password;
	@Transient
	@Size(min=8,max=64,message="password must be between 8-64 characters.")
	private String passwordConfirmation;
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public User() {
	}
    

	public User(Long id,
			@Size(min = 2, max = 40, message = "First Name must be between 2-40 characters.") String firstName,
			@Size(min = 2, max = 40, message = "Last Name must be between 2-40 characters.") String lastName,
			@Email String email,
			@Size(min = 8, max = 64, message = "password must be between 8-64 characters.") String password,
			@Size(min = 8, max = 64, message = "password must be between 8-64 characters.") String passwordConfirmation) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}


	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}


	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
