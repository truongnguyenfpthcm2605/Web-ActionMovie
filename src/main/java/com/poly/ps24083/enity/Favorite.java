package com.poly.ps24083.enity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name ="FAVORITE",uniqueConstraints = {
		@UniqueConstraint(columnNames = {"userid","videoid"})
})
public class Favorite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	
	@ManyToOne @JoinColumn(name="userid", referencedColumnName = "id")
	Users user;
	
	@ManyToOne @JoinColumn(name="videoid", referencedColumnName = "id")
	Video video;
	
	@Temporal(TemporalType.DATE)
	private Date likedate = new Date();
	
	private Boolean active;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Date getLikedate() {
		return likedate;
	}

	public void setLikedate(Date likedate) {
		this.likedate = likedate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	
	
	
	
	
}
