package com.matthewdyer.assignment1.service;

import java.util.List;

import com.matthewdyer.assignment1.domain.Episode;
import com.matthewdyer.assignment1.domain.MediaItem;

public interface MediaItemService {

	public List<MediaItem> findAll();
	
	public MediaItem findById(Long id);
	
	public MediaItem save(MediaItem mediaItem);
	
	public void delete(MediaItem mediaItem);
	
	public List<Episode> findAllEpisodes(MediaItem m);
	
	public Episode findEpisodeById(Long id);
	
	public Episode saveEpisode(Episode e);
	
	public void delete(Episode e);
}
