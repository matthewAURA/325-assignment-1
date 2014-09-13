package com.matthewdyer.assignment1.persistance;

import java.util.List;

import com.matthewdyer.assignment1.domain.MediaItem;
import com.matthewdyer.assignment1.domain.Rating;

public interface RatingDAO {
	public List<Rating> findAll();
	public Rating findById(long id);
	public void save(Rating m);
	public void delete(Rating m);
}
