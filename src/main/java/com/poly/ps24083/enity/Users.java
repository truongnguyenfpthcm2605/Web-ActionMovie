package com.poly.ps24083.enity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="USERS")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		private String username;
		private String pass;
		private String email;
		private String fullname;
		private Date birth;
		private Date starday   = new Date();
		private String avatar;
		private Boolean admin;
		private Boolean active;
		private Integer vip;
		
		@OneToMany(mappedBy = "user")
		List<Favorite> favorites;
		
		@OneToMany(mappedBy = "user")
		List<Share> shares;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPass() {
			return pass;
		}

		public void setPass(String pass) {
			this.pass = pass;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getFullname() {
			return fullname;
		}

		public void setFullname(String fullname) {
			this.fullname = fullname;
		}

		public Date getBirth() {
			return birth;
		}

		public void setBirth(Date birth) {
			this.birth = birth;
		}

		public Date getStarday() {
			return starday;
		}

		public void setStarday(Date starday) {
			this.starday = starday;
		}

		public String getAvatar() {
			return avatar;
		}

		public void setAvatar(String avatar) {
			this.avatar = avatar;
		}

		public Boolean getAdmin() {
			return admin;
		}

		public void setAdmin(Boolean admin) {
			this.admin = admin;
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

		public List<Favorite> getFavorites() {
			return favorites;
		}

		public void setFavorites(List<Favorite> favorites) {
			this.favorites = favorites;
		}

		public List<Share> getShares() {
			return shares;
		}

		public void setShares(List<Share> shares) {
			this.shares = shares;
		}
		
}
