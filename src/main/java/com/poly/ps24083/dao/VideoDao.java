package com.poly.ps24083.dao;

import java.util.List;

import com.poly.ps24083.enity.Video;

public interface VideoDao {
		public Video findById(Integer id);
		public Video findByLink(String link);
		public List<Video> findAll();
		public List<Video> findPage(int pageNumber, int pageSize);
		public List<Video> findvideoVip(boolean vip);
		public boolean insert(Video enity);
		public boolean update(Video enity);
		public boolean delete(Video enity);
		public List<Video> findUsersToShare(Integer usid);
		
}
