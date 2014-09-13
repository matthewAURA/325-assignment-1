package com.matthewdyer.assignment1.domain;

import java.io.Serializable;
import java.util.List;


public class MediaItems implements Serializable {

	private List<MediaItem> mediaItems;

	public MediaItems() {
	}
	
	public MediaItems(List<MediaItem> mediaItems) {
		this.mediaItems = mediaItems;
	}
	
	public List<MediaItem> getMediaItems() {
		return mediaItems;
	}

	public void setMediaItems(List<MediaItem> mediaItems) {
		this.mediaItems = mediaItems;
	}
	 
}
