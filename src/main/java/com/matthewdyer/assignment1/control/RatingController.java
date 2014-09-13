package com.matthewdyer.assignment1.control;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.matthewdyer.assignment1.domain.MediaItem;
import com.matthewdyer.assignment1.domain.MediaItems;
import com.matthewdyer.assignment1.domain.Rating;
import com.matthewdyer.assignment1.domain.Ratings;
import com.matthewdyer.assignment1.service.MediaItemService;
import com.matthewdyer.assignment1.service.RatingService;





@Controller
@RequestMapping(value="/Ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Ratings listData(WebRequest webRequest) {
		return new Ratings(ratingService.findAll());
	}	
  
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Rating findContactById(@PathVariable Long id) {		
		return ratingService.findById(id);
	}
	
	@RequestMapping(value="/Create", method=RequestMethod.POST)
	@ResponseBody
	public Rating create(@RequestBody Rating r, HttpServletResponse response) {
		ratingService.save(r);
		response.setHeader("Location",  "/Ratings/" + r.getId());
		return r;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@ResponseBody
	public Rating update(@RequestBody Rating r, @PathVariable Long id) {	
		r.setId(id);
		this.ratingService.save(r);
		return r;
	}


}
