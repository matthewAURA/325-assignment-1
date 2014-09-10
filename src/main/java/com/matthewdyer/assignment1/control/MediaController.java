package com.matthewdyer.assignment1.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.matthewdyer.assignment1.domain.MediaItems;
import com.matthewdyer.assignment1.service.MediaItemService;





@Controller
@RequestMapping(value="/")
public class MediaController {
	
	@Autowired
	private MediaItemService mediaItemService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public MediaItems listData(WebRequest webRequest) {
		return new MediaItems(mediaItemService.findAll());
	}	
  


}
