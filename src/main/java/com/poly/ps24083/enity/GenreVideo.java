package com.poly.ps24083.enity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GENREVIDEO")
public class GenreVideo {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		private String title;
		
		@OneToMany(mappedBy = "genre")
		List<Video> videos;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public List<Video> getVideos() {
			return videos;
		}
		public void setVideos(List<Video> videos) {
			this.videos = videos;
		}
		
		
		
}
