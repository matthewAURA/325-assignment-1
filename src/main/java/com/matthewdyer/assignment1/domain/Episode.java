package com.matthewdyer.assignment1.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MEDIA_EPISODE")
public class Episode implements Serializable {
	
	private long id;
	private Media media;
	private int season;
	private String episodeTitle;
	
	public Episode(){}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "MEDIA_ID")
	public Media getMedia() {
		return this.media;
	}

	public void setMedia(Media m) {
		this.media = m;
	}
	
	@Column(name ="SEASON")
	public int getSeason(){
		return this.season;
	}
	
	public void setSeason(int s){
		this.season = s;
	}
	
	@Column(name="EPISODE_TITLE")
	public String getTitle(){
		return this.episodeTitle;
	}
	
	public void setTitle(String t){
		this.episodeTitle = t;
	}
	
	
}
