package com.poly.ps24083.dao;

import java.util.List;

import com.poly.ps24083.enity.Users;

public interface UserDao {
		public Users findByID(Integer id) ;
		public Users findByEmail(String email);
		public Users findbyUsername(String username);
		public Users findByUser(String user, String password);
		public List<Users> findAll();
		public List<Users> findPage(int pageNumber, int pageSize);
		public List<Users> findUserVip(boolean vip);
		public boolean insert(Users enity);
		public boolean update(Users enity);
		public boolean delete(String username);
		public List<Users> findAllUserToFavoriteVideo(Integer videoid);
		public List<Users> findAllUserToShareVideo(Integer videoid);
		public List<Users> findAllUserToReport(Integer rpid);
		public List<Users> findAllUserToFeedback(Integer usid);
		
}
