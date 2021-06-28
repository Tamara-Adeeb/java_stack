package com.Tamara.authentication.models;

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
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
@Table(name="events")
public class Event {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	@NotNull
	@Size(min=2,max=40)
	private String event;
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	private String location;
	private String[] state = {"CA","WA","AZ"};
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User host;
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
    		name="users_events",
    		joinColumns=@JoinColumn(name="event_id"),
    		inverseJoinColumns=@JoinColumn(name="user_id")
    		)
    private List<User> joinedUsers;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}
