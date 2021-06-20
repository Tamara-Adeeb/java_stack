package com.Tamara.Firstmvc.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
@Table(name = "books")
public class Book {
	@Id // This implies the values are unique, that they aren't null and that they won't
		// be modified.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // they are auto-incremented.
	private Long id;
	@NotNull
	@Size(min = 5, max = 200)
	private String title;
	@NotNull
	@Size(min = 5, max = 200)
	private String description;
	@NotNull
	@Size(min = 3, max = 40)
	private String language;
	@NotNull
	@Min(100)
	private Integer numberOfPages;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	public Book() {
	}

	public Book(@Size(min = 5, max = 200) String title, @Size(min = 5, max = 200) String description,
			@Size(min = 3, max = 40) String language, @Min(100) Integer numberOfPages) {
		this.title = title;
		this.description = description;
		this.language = language;
		this.numberOfPages = numberOfPages;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

}
