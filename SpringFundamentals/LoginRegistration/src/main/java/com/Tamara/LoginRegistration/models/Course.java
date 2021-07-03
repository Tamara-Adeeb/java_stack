package com.Tamara.LoginRegistration.models;

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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="courses")
public class Course {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotNull
	@Size(min=2,max=40,message="Course Name must be between 2-40 characters.")
	private String name;
	@NotNull
	private String instructor;
	@Min(0)
	private int signups=0;
	@Min(1)
	private int capacity;
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
    		name="users_courses",
    		joinColumns = @JoinColumn(name="course_id"),
    		inverseJoinColumns = @JoinColumn(name="user_id")
    		)
    private List<User> users;
    
	
	public Course() {
		
	}
	
	
    
	public Course(Long id,
			@NotNull @Size(min = 2, max = 40, message = "Course Name must be between 2-40 characters.") String name,
			@NotNull String instructor, @Min(0) int signups, @Min(1) int capacity, List<User> users) {
		this.id = id;
		this.name = name;
		this.instructor = instructor;
		this.signups = signups;
		this.capacity = capacity;
		this.users = users;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}


	public int getSignups() {
		return signups;
	}

	public void setSignups(int signups) {
		this.signups = signups;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public void addUser(User user) {
		if(!this.users.contains(user)) {
			this.users.add(user);
		}
	}
	
	public void removeUser(User user) {
		if(this.users.contains(user)) {
			this.users.remove(user);
		}
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
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
