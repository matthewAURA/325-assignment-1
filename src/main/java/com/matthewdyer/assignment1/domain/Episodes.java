package com.matthewdyer.assignment1.domain;

import java.io.Serializable;
import java.util.List;


public class Episodes implements Serializable {

	private List<Episode> episodes;

	public Episodes() {
	}
	
	public Episodes(List<Episode> rating) {
		this.episodes = rating;
	}
	
	public List<Episode> getEpisodes() {
		return episodes;
	}

	public void setRating(List<Episode> rating) {
		this.episodes = rating;
	}
	 
}
