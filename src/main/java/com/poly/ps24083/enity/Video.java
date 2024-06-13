package com.poly.ps24083.enity;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;




@Entity
@Table(name = "VIDEO", uniqueConstraints = { @UniqueConstraint(columnNames = { "idgenre" }) })
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String poster;
	private Integer views;
	private String link;
	private String descriptions;
	private Boolean active;
	private Integer vip;
	private String quality;

	private Date dayupload = new Date();

	private Integer times;

	@ManyToOne
	@JoinColumn(name = "idgenre", referencedColumnName = "id")
	GenreVideo genre;

	@OneToMany(mappedBy = "video")
	List<Favorite> favorites;

	@OneToMany(mappedBy = "video")
	List<Share> shares;

	public List<Share> getShares() {
		return shares;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}

	public List<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

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

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Integer getVip() {
		return vip;
	}

	public void setVip(Integer vip) {
		this.vip = vip;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public Date getDayupload() {
		return dayupload;
	}

	public void setDayupload(Date dayupload) {
		this.dayupload = dayupload;
	}

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	public GenreVideo getGenre() {
		return genre;
	}

	public void setGenre(GenreVideo genre) {
		this.genre = genre;
	}

	public Integer getTotalShares() {
		if (shares == null || shares.isEmpty()) {
			return 0;
		}

		Integer totalShares = 0;
		for (Share share : shares) {
			totalShares += share.getNumber();
		}
		return totalShares;
	}

	public Integer getTotalFavorites() {
		if (favorites == null || favorites.isEmpty()) {
			return 0;
		}
		Integer totalFavorites = 0;
		for (Favorite favorite : favorites) {
			if (favorite.getActive()) {
				totalFavorites += 1;
			}
		}
		return totalFavorites;
	}

}
