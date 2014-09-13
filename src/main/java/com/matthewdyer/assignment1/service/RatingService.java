package com.matthewdyer.assignment1.service;

import java.util.List;

import com.matthewdyer.assignment1.domain.MediaItem;
import com.matthewdyer.assignment1.domain.Rating;

public interface RatingService {

	public List<Rating> findAll();
	
	public Rating findById(Long id);
	
	public Rating save(Rating rating);
	
	public void delete(Rating rating);
}
