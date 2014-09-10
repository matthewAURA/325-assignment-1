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
import com.matthewdyer.assignment1.service.MediaItemService;





@Controller
@RequestMapping(value="/MediaItems")
public class MediaController {
	
	@Autowired
	private MediaItemService mediaItemService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public MediaItems listData(WebRequest webRequest) {
		return new MediaItems(mediaItemService.findAll());
	}	
  
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseBody
	public MediaItem findContactById(@PathVariable Long id) {		
		return mediaItemService.findById(id);
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	@ResponseBody
	public MediaItem create(@RequestBody MediaItem m, HttpServletResponse response) {
		mediaItemService.save(m);
		response.setHeader("Location",  "/MediaItems/" + m.getId());
		return m;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@ResponseBody
	public void update(@RequestBody MediaItem m, @PathVariable Long id) {		
		this.mediaItemService.save(m);
	}


}
