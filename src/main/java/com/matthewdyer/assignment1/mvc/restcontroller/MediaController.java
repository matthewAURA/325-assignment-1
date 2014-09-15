package com.matthewdyer.assignment1.mvc.restcontroller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.matthewdyer.assignment1.domain.Episode;
import com.matthewdyer.assignment1.domain.Episodes;
import com.matthewdyer.assignment1.domain.MediaItem;
import com.matthewdyer.assignment1.domain.MediaItems;
import com.matthewdyer.assignment1.service.MediaItemService;





@Controller
@RequestMapping(value="/")
public class MediaController {
	final Logger logger = LoggerFactory.getLogger(MediaController.class);
	
	@Autowired
	private MediaItemService mediaItemService;
	

	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model uiModel) {
		uiModel.addAttribute("mediaItems", mediaItemService.findAll());
		
		// Return the logical name of the view.
		return "media/list";
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public String show(@PathVariable Long id,Model uiModel) {
		MediaItem m = this.mediaItemService.findById(id);
		uiModel.addAttribute("mediaItem", m);
		uiModel.addAttribute("episodes", m.getEpisodes());
		
		// Return the logical name of the view.
		return "media/show";
	}
	
	@RequestMapping(value="{id}/edit",method = RequestMethod.GET)
	public String edit(@PathVariable Long id,Model uiModel) {
		MediaItem m = this.mediaItemService.findById(id);
		uiModel.addAttribute("mediaItem", m);
		uiModel.addAttribute("episodes", m.getEpisodes());
		
		// Return the logical name of the view.
		return "media/edit";
	}
	
	@RequestMapping(value="/create",method = RequestMethod.GET)
	public String newMediaItem(Model uiModel) {
		
		// Return the logical name of the view.
		return "media/edit";
	}
	
	
	
	@RequestMapping(value="{id}/edit", method=RequestMethod.POST)
	@ResponseBody
	public MediaItem create(@RequestBody MediaItem m, HttpServletResponse response) {
		logger.info("Creating MediaItem: "+m);
		mediaItemService.save(m);
		response.setHeader("Location",  "/MediaItems/" + m.getId());
		return m;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@ResponseBody
	public void update(@RequestBody MediaItem m, @PathVariable Long id) {		
		logger.info("Updating MediaItem: "+m);
		this.mediaItemService.save(m);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@ResponseBody
	public void delete(@RequestBody MediaItem m, @PathVariable Long id, HttpServletResponse response) {		
		logger.info("Deleting MediaItem: "+m);
		this.mediaItemService.delete(m);
		response.setHeader("Location",  "/MediaItems/");
	}
	
	/*
	@RequestMapping(value="/{id}/Episodes", method=RequestMethod.GET)
	@ResponseBody
	public Episodes findEpisodesById(@PathVariable Long id) {		
		MediaItem m = this.mediaItemService.findById(id);
		return new Episodes(mediaItemService.findAllEpisodes(m));
	}
	
	@RequestMapping(value="/{id}/Episodes/{eId}", method=RequestMethod.GET)
	@ResponseBody
	public Episode findEpisodeById(@PathVariable Long id,@PathVariable Long eId) {		
		return mediaItemService.findEpisodeById(eId);
	}*/
	
	@RequestMapping(value="/{id}/Episodes/Create", method=RequestMethod.POST)
	@ResponseBody
	public MediaItem createEpisode(@PathVariable Long id,@RequestBody Episode e, HttpServletResponse response) {
		MediaItem m = this.mediaItemService.findById(id);
		logger.info("Creating Episode " + e + " for MediaItem" + m);
		e.setMedia(m);
		this.mediaItemService.saveEpisode(e);
		response.setHeader("Location",  "/MediaItems/" + m.getId());
		return m;
	}
	
	@RequestMapping(value="/{id}/Episodes/{eId}", method=RequestMethod.PUT)
	@ResponseBody
	public Episode updateEpisode(@PathVariable Long id,@PathVariable Long eId,@RequestBody Episode e) {		
		logger.info("Updating Episode " + e);
		return mediaItemService.saveEpisode(e);
	}
	
	@RequestMapping(value="/{id}/Episodes/{eId}", method=RequestMethod.DELETE)
	@ResponseBody
	public void deleteEpisode(@PathVariable Long id,@PathVariable Long eId,@RequestBody Episode e,HttpServletResponse response) {	
		logger.info("Deleting Episode " + e);
		 mediaItemService.delete(e);
		 response.setHeader("Location", "/"+ id.toString() +"/Episodes/");
	}


}
