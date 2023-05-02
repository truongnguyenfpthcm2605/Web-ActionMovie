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
@Table(name ="SHARE",uniqueConstraints = {
		@UniqueConstraint(columnNames = {"userid","videoid"})
})
public class Share {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	
	@ManyToOne @JoinColumn(name="userid", referencedColumnName = "id")
	Users user;
	
	@ManyToOne @JoinColumn(name="videoid", referencedColumnName = "id")
	Video video;
	
	private String emails;
	private int number;
	@Temporal(TemporalType.DATE)
	private Date sharedate = new Date();
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
	public String getEmails() {
		return emails;
	}
	public void setEmails(String emails) {
		this.emails = emails;
	}
	public Date getSharedate() {
		return sharedate;
	}
	public void setSharedate(Date sharedate) {
		this.sharedate = sharedate;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
}
