package com.matthewdyer.assignment1.service;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.matthewdyer.assignment1.domain.MediaItem;
import com.matthewdyer.assignment1.domain.Rating;
import com.matthewdyer.assignment1.persistance.MediaDAO;
import com.matthewdyer.assignment1.persistance.RatingDAO;

@Service("ratingService")
public class DefaultRatingService implements RatingService {
	
	private RatingDAO ratingDAO;
	
	public DefaultRatingService(){
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context.xml");
		ctx.refresh();
		
		this.ratingDAO = ctx.getBean("ratingDAO",RatingDAO.class);
	}

	@Override
	public List<Rating> findAll() {
		return ratingDAO.findAll();
	}

	@Override
	public Rating findById(Long id) {
		return ratingDAO.findById(id);
	}

	@Override
	public Rating save(Rating rating) {
		ratingDAO.save(rating);
		return rating;
	}

	@Override
	public void delete(Rating rating) {
		ratingDAO.delete(rating);
	}
	


}
