package com.matthewdyer.assignment1.mvc.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.matthewdyer.assignment1.mvc.restcontroller.MediaController;


@Controller
@RequestMapping(value="/test")
public class WebViewController {
	final Logger logger = LoggerFactory.getLogger(MediaController.class);

	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model uiModel) {
		// Return the logical name of the view.
		return "media/list";
	}
 

}
