package com.matthewdyer.assignment1.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RATING")
public class Rating {
	
	private long id;
	private String ratingName;
	
	public Rating(){}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	@Column(name ="RATING_NAME")
	public String getRatingName(){
		return this.ratingName;
	}
	
	public void setRatingName(String r){
		this.ratingName = r;
	}
}
