package com.matthewdyer.assignment1.domain;

import java.io.Serializable;
import java.util.List;


public class Ratings implements Serializable {

	private List<Rating> ratings;

	public Ratings() {
	}
	
	public Ratings(List<Rating> rating) {
		this.ratings = rating;
	}
	
	public List<Rating> getRating() {
		return ratings;
	}

	public void setRating(List<Rating> rating) {
		this.ratings = rating;
	}
	 
}
