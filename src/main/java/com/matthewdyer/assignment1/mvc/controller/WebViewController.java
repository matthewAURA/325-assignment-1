package com.matthewdyer.assignment1.mvc.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.matthewdyer.assignment1.domain.MediaItem;
import com.matthewdyer.assignment1.mvc.restcontroller.MediaController;
import com.matthewdyer.assignment1.service.MediaItemService;


@Controller
@RequestMapping(value="/")
public class WebViewController {
	final Logger logger = LoggerFactory.getLogger(MediaController.class);
	
	@Autowired
	private MediaItemService mediaItemService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model uiModel) {
		uiModel.addAttribute("mediaItems", mediaItemService.findAll());
		
		// Return the logical name of the view.
		return "media/list";
	}
	
	@RequestMapping(value="{id}",method = RequestMethod.GET)
	public String show(@PathVariable Long id,Model uiModel) {
		MediaItem m = this.mediaItemService.findById(id);
		uiModel.addAttribute("mediaItem", m);
		uiModel.addAttribute("episodes", m.getEpisodes());
		
		// Return the logical name of the view.
		return "media/show";
	}
 

}
