package com.Tamara.Lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
@Table(name="songs")
public class Song {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotNull
	@Size(min=5,max=40)
	private String title;
	@NotNull
	@Size(min=5,max=40)
	private String artist;
	@Range(min=1, max=10)
	private int rating;
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Song() {}



	public Song(@Size(min = 5, max = 40) String title, @Size(min = 5, max = 40) String artist,
			@Range(min = 1, max = 10) int rating) {
		super();
		this.title = title;
		this.artist = artist;
		this.rating = rating;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
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
