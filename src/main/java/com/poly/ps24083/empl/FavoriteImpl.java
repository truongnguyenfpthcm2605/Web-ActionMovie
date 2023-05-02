package com.poly.ps24083.empl;

import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import com.poly.ps24083.dao.DAO;
import com.poly.ps24083.dao.FavoriteDao;
import com.poly.ps24083.enity.Video;

public class FavoriteImpl extends DAO<Video> implements FavoriteDao {

	// lấy ra lít video của người dùng yêu thích hoặc không
	public List<Video> findAllVideoofUserfavorited(Integer usid, boolean active) {
		String sql = "SELECT o.video FROM Favorite o WHERE o.user.id = ?0 AND o.active = ?1 "
				+ "ORDER BY o.likedate DESC";
		return super.findMany(Video.class, sql, usid, active);
	}
	
	// lấy ra  video được yêu thích hoặc không
	public List<Video> getVideoFavoriteOrNot(boolean check) {
		String jpql;
		if (check) {
			jpql = "SELECT o FROM Video o JOIN o.favorites f WHERE f.active = 1";
		} else {
			jpql = "SELECT o FROM Video o WHERE o.favorites IS  EMPTY";
		}		
		return super.findMany(Video.class, jpql);
	}
	
	// lấy ra  video được chia sẻ hoặc không
	public List<Video> getVideoShareOrNot(boolean check) {
		String jpql;
		if (check) {
			jpql = "SELECT o FROM Video o WHERE o.shares IS NOT  EMPTY";
		} else {
			jpql = "SELECT o FROM Video o WHERE o.shares IS  EMPTY";
		}		
		return super.findMany(Video.class, jpql);
	}

	// lấy ra list video theo title của ngươi dùng yêu thích khi tìm kiếm
	@Override
	public List<Video> findTitleVideoofUserfavorited(Integer usid, String titleVideo) {
		String sql = "SELECT  f.video FROM Favorite f WHERE f.user.id = ?0 AND f.active = 1 AND f.video.title LIKE ?1";
		return super.findMany(Video.class, sql, usid, "%" + titleVideo + "%");
	}

	// lấy ra list video trong khoảng thời gian
	@Override
	public List<Video> findVideoInRangeofUserfavorited(Integer usid, Date min, Date max) {
		String sql = "SELECT   o.video FROM Favorite o WHERE  " + "o.user.id = ?0 AND o.active = 1 "
				+ "And o.likedate BETWEEN ?1 AND ?2";
		return super.findMany(Video.class, sql, usid, min, max);
	}

	// lấy ta list video theo tháng
	@Override
	public List<Video> findVideoInMonths(Integer usid, Integer[] months) {
		String sql = "SELECT  o.video FROM Favorite o  WHERE  "
				+ "o.user.id = ?0 AND o.active = 1  month(o.likedate) IN (?1)";
		return super.findMany(Video.class, sql, usid, months);
	}

	// lấy ra list video theo title
	public List<Video> findbyTitle(String title, boolean active) {
		String sql = "SELECT  f  FROM Video f  WHERE  f.active = ?0 AND f.title LIKE ?1";
		return super.findMany(Video.class, sql, active, "%" + title + "%");
	}

	public List<Video> findbyTitleGenre(String title, Integer genreid, boolean active) {
		String sql = "SELECT  f  FROM Video f  WHERE  f.active = ?0 AND f.title LIKE ?1 AND f.genre.id = ?2";
		return super.findMany(Video.class, sql, active, "%" + title + "%", genreid);
	}
	
	public List<Video> findByview(){
		String sql = "SELECT o From  Video o  ORDER BY o.views DESC";
		return super.findMany(Video.class, sql);
	}
	
	


}
