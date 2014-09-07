package com.matthewdyer.assignment1.persistance;

import java.util.List;

import com.matthewdyer.assignment1.domain.Media;

public interface MediaDAO {
	public List<Media> findAll();
	public Media findById(long id);
	public void save(Media m);
	public void delete(Media m);
}
