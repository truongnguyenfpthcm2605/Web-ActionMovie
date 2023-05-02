package com.poly.ps24083.empl;

import java.util.List;

import javax.management.Query;
import javax.persistence.TypedQuery;

import com.poly.ps24083.dao.DAO;
import com.poly.ps24083.dao.VideoDao;
import com.poly.ps24083.enity.Video;

public class VideoImlpl extends DAO<Video> implements VideoDao {

	@Override
	public Video findById(Integer id) {
		return super.findByid(Video.class, id);
	}

	@Override
	public Video findByLink(String link) {
		String sql = "SELECT o FROM Video o WHERE o.link = ?0";
		return super.findOne(Video.class, sql, link);
	}

	@Override
	public List<Video> findAll() {
		return super.findAll(Video.class, true);
	}

	@Override
	public List<Video> findPage(int pageNumber, int pageSize) {
		return super.findToPage(Video.class, true, pageNumber, pageSize);
	}

	@Override
	public boolean insert(Video enity) {
		enity.setActive(true);
		return super.insert(enity);
	}

	@Override
	public boolean update(Video enity) {
		return super.update(enity);
	}

	@Override
	public boolean delete(Video enity) {
		return super.delete(enity);
	}

	// hiển thị nhưng video mà người dùng đó đã share
	@Override
	public List<Video> findUsersToShare(Integer usid) {
		String sql = "SELECT o.video  FROM Share o WHERE o.user.id = ?0 ORDER BY o.sharedate DESC ";
		return super.findMany(Video.class, sql, usid);
	}

	@Override
	public List<Video> findvideoVip(boolean vip) {
		String sql = "SELECT o  FROM Video o WHERE o.vip = ?0 ";
		return super.findMany(Video.class, sql, vip);
	}

	public List<Video> findVideotoUserReport(Integer usid) {
		String sql = "SELECT o.video  FROM Report o WHERE o.user.id = ?0  ";
		return super.findMany(Video.class, sql, usid);
	}
	
	public List<Video> findVideoGenre(Integer videogenreid){
		String sql = "SELECT o  FROM Video o WHERE o.genre.id = ?0  ";
		TypedQuery<Video> query = em.createQuery(sql,Video.class);
		query.setParameter(0, videogenreid);
		query.setMaxResults(4);
		return query.getResultList();
	}
	
	public List<Video> findVideoGenreAll(Integer videogenreid){
		String sql = "SELECT o  FROM Video o WHERE o.genre.id = ?0  ";
		TypedQuery<Video> query = em.createQuery(sql,Video.class);
		query.setParameter(0, videogenreid);
		return query.getResultList();
	}
	
	public List<Video> pageVideoNumber(int pageSize,int pageNumber, Integer genreid){
		String sql = "SELECT o FROM Video o  WHERE o.active =1 and o.genre.id =?0 ";
		TypedQuery<Video> query = em.createQuery(sql,Video.class);
		query.setParameter(0, genreid);
		query.setFirstResult((pageNumber - 1)*pageSize );
		query.setMaxResults(pageSize);
		List<Video> list = query.getResultList();
		if(list.isEmpty()) {
			return null;
		}
		return list;
	}
	
	
	public List<Video> pageVideoNumberTitleByGenre(int pageNumber,int pagsize, Integer genreid,String title){
		String sql = "SELECT o FROM Video o  WHERE o.active =1 and o.genre.id =?0  And o.title =?1";
		return super.findManyPage(Video.class, sql, pageNumber, pagsize, genreid,title);
		
	}
	public List<Video> pageVideoNumberTitle(int pageNumber,int pagsize, String title){
		String sql = "SELECT o FROM Video o  WHERE o.active =1   And o.title =?0";
		return super.findManyPage(Video.class, sql, pageNumber, pagsize,title);
		
	}
	
	public List<Video> findVideoUnActive(){
		String sql = "SELECT o FROM Video o  WHERE o.active =0 ";
		return super.findMany(Video.class, sql);
		
	}
	
	public List<Video> findTitleVideo(String title){
		String sql = "SELECT o FROM Video o  WHERE o.active =1  And o.title like ?0";
		return super.findMany(Video.class, sql,"%"+title+"%");
	}
	
	
	
	
	

}
