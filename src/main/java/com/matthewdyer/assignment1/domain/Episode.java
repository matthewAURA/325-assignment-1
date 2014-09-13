package com.matthewdyer.assignment1.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "MEDIA_EPISODE")

@NamedQueries({
	@NamedQuery(name="Episode.findById", query="select distinct e from Episode e where e.id = :id")
			})
public class Episode implements Serializable {
	
	private long id;
	private MediaItem media;
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
	public MediaItem getMedia() {
		return this.media;
	}

	public void setMedia(MediaItem m) {
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
	public String getEpisodeTitle(){
		return this.episodeTitle;
	}
	
	public void setEpisodeTitle(String t){
		this.episodeTitle = t;
	}
	
	
}
