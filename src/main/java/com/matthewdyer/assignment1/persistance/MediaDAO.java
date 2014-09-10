package com.matthewdyer.assignment1.persistance;

import java.util.List;

import com.matthewdyer.assignment1.domain.MediaItem;

public interface MediaDAO {
	public List<MediaItem> findAll();
	public MediaItem findById(long id);
	public void save(MediaItem m);
	public void delete(MediaItem m);
}
