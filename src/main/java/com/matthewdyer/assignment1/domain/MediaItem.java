package com.matthewdyer.assignment1.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "MEDIA")

@NamedQueries({
	@NamedQuery(name="MediaItem.findById", query="select distinct m from MediaItem m left join fetch m.episodes e where m.id = :id")
			})
public class MediaItem implements Serializable {
	protected long id;
	protected String title;
	protected String description;
	protected Rating rating;
	private Set<Episode> episodes;
	public MediaItem(){
		
	}
	
	protected MediaItem(String name, String description,Rating rating,long id){
		this(name,description);
		this.id = id;
	}
	
	protected MediaItem(String name, String description){
		this.title = name;
		this.description = description;
	}
	
	@OneToMany(mappedBy = "media", targetEntity=Episode.class, orphanRemoval=true, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<Episode> getEpisodes() {
		return this.episodes;
	}

	public void setEpisodes(Set<Episode> episodes) {
		this.episodes = episodes;
	}
	
	@Column(name = "TITLE")
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String name){
		this.title = name;
	}
	
	@Column(name = "DESCRIPTION")
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String desc){
		this.description = desc;
	}
	
	@ManyToOne
	@JoinColumn(name = "RATING_ID")
	public Rating getRating(){
		return rating;
	}
	
	public void setRating(Rating r){
		this.rating = r;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID")
	public long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id = id;
	}
	
	public String toString(){
		return this.title + " " + this.description;
	}
}
