package com.matthewdyer.assignment1.service;

import java.util.List;




import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.matthewdyer.assignment1.domain.MediaItem;
import com.matthewdyer.assignment1.persistance.MediaDAO;

@Service("mediaItemService")
public class DefaultMediaItemService implements MediaItemService {
	
	private MediaDAO mediaDAO;
	
	public DefaultMediaItemService(){
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context.xml");
		ctx.refresh();
		
		this.mediaDAO = ctx.getBean("mediaDAO",MediaDAO.class);

	}
	
	
	@Override
	public List<MediaItem> findAll() {
		return this.mediaDAO.findAll();
	}

	@Override
	public MediaItem findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MediaItem save(MediaItem contact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(MediaItem contact) {
		// TODO Auto-generated method stub

	}

}
