package com.matthewdyer.assignment1.service;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.matthewdyer.assignment1.domain.Episode;
import com.matthewdyer.assignment1.domain.MediaItem;
import com.matthewdyer.assignment1.persistance.EpisodeDAO;
import com.matthewdyer.assignment1.persistance.MediaDAO;

@Service("mediaItemService")
public class DefaultMediaItemService implements MediaItemService {
	
	private MediaDAO mediaDAO;
	private EpisodeDAO episodeDAO;
	
	public DefaultMediaItemService(){
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context.xml");
		ctx.refresh();
		
		this.mediaDAO = ctx.getBean("mediaDAO",MediaDAO.class);
		this.episodeDAO = ctx.getBean("episodeDAO",EpisodeDAO.class);
	}
	
	
	@Override
	public List<MediaItem> findAll() {
		return this.mediaDAO.findAll();
	}

	@Override
	public MediaItem findById(Long id) {
		return this.mediaDAO.findById(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public MediaItem save(MediaItem m) {
		return this.mediaDAO.save(m);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void delete(MediaItem m) {
		this.mediaDAO.delete(m);
	}


	@Override
	public List<Episode> findAllEpisodes(MediaItem m) {
		return episodeDAO.findAll();
	}


	@Override
	public Episode findEpisodeById(Long id) {
		return episodeDAO.findById(id);
	}


	@Override
	public Episode saveEpisode(Episode e) {
		return this.episodeDAO.save(e);
	}


	@Override
	public void delete(Episode e) {
		this.episodeDAO.delete(e);
	}

}
