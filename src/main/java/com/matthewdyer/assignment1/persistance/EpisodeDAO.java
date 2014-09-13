package com.matthewdyer.assignment1.persistance;

import java.util.List;

import com.matthewdyer.assignment1.domain.Episode;
import com.matthewdyer.assignment1.domain.MediaItem;
import com.matthewdyer.assignment1.domain.Rating;

public interface EpisodeDAO {
	public List<Episode> findAll();
	public Episode findById(long id);
	public Episode save(Episode m);
	public void delete(Episode m);
}
