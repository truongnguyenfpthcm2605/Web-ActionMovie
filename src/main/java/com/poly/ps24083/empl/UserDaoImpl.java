package com.poly.ps24083.empl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder.In;

import com.poly.ps24083.dao.DAO;
import com.poly.ps24083.dao.UserDao;
import com.poly.ps24083.enity.Users;
import com.poly.ps24083.service.JpaProgram;

public class UserDaoImpl extends DAO<Users> implements UserDao {
	
	
	

	@Override
	public Users findByID(Integer id) {
		return super.findByid(Users.class, id);
	}

	@Override
	public Users findByEmail(String email) {
		String sql = "SELECT o FROM Users o WHERE o.email =?0";
		return super.findOne(Users.class, sql, email);
	}

	@Override
	public Users findbyUsername(String username) {
		String sql = "SELECT o FROM Users o WHERE o.username =?0";
		return super.findOne(Users.class, sql, username);
	}

	@Override
	public Users findByUser(String user, String password) {
		String sql = "SELECT o FROM Users o WHERE o.username =?0 AND  o.pass =?1 And o.active =1";
		return super.findOne(Users.class, sql, user, password);
	}

	@Override
	public List<Users> findAll() {
		return super.findAll(Users.class, true);
	}

	@Override
	public boolean insert(Users enity) {
		return super.insert(enity);
	}

	@Override
	public boolean update(Users enity) {
		return super.update(enity);
	}

	@Override
	public boolean delete(String usename) {
		Users us = findbyUsername(usename);
		us.setActive(false);
		return super.update(us);
	}

	@Override
	public List<Users> findPage(int pageNumber, int pageSize) {
		return super.findToPage(Users.class, true, pageNumber, pageSize);
	}

	// hiển thị những user đã share video đó
	@Override
	public List<Users> findAllUserToShareVideo(Integer videoid) {
		String sql = "SELECT o.user  FROM Share o WHERE o.video.id = ?0 ORDER BY o.sharedate DESC ";
		return super.findMany(Users.class, sql, videoid);
	}

	// lấy ra những người yêu thích video đó
	@Override
	public List<Users> findAllUserToFavoriteVideo(Integer videoid) {
		String sql = "SELECT o.user  FROM Favorite o WHERE o.video.id = ?0 AND o.active =1 ORDER BY o.likedate DESC ";
		return super.findMany(Users.class, sql, videoid);
	}

	@Override
	public List<Users> findUserVip(boolean vip) {
		String sql = "SELECT o  FROM Users o WHERE o.vip = ?0 ";
		return super.findMany(Users.class, sql, vip);
	}

	@Override
	public List<Users> findAllUserToReport(Integer videoid) {
		String sql = "SELECT o.user  FROM Report o WHERE o.video.id = ?0 ";
		return super.findMany(Users.class, sql, videoid);
	}

	@Override
	public List<Users> findAllUserToFeedback(Integer usid) {

		return null;
	}

	public List<Map<String, Object>> findAllUserToFavoriteVideoDate(Integer videoid) {
	    String sql = "SELECT o.user, o.likedate FROM Favorite o WHERE o.video.id = ?0 AND o.active =1 ORDER BY o.likedate DESC";
	    List<Object[]> results = super.findManyDate(sql, videoid);
	    List<Map<String, Object>> usersAndLikes = new ArrayList<>();
	    for (Object[] result : results) {
	        Users user = (Users) result[0];
	        Date likedate = (Date) result[1];
	        Map<String, Object> userAndLike = new HashMap<>();
	        userAndLike.put("user", user);
	        userAndLike.put("likedate", likedate);
	        usersAndLikes.add(userAndLike);
	    }
	    return usersAndLikes;
	}
	
	public List<Map<String, Object>> findAllUserToShareVideoDate(Integer videoid) {
	    String sql = "SELECT o.user, o.sharedate, o.number FROM Share o WHERE o.video.id = ?0 ORDER BY o.sharedate DESC";
	    List<Object[]> results = super.findManyDate(sql, videoid);
	    List<Map<String, Object>> usersAndLikes = new ArrayList<>();
	    for (Object[] result : results) {
	        Users user = (Users) result[0];
	        Date sharedate = (Date) result[1];
	        int number = (int) result[2];
	        Map<String, Object> userAndLike = new HashMap<>();
	        userAndLike.put("user", user);
	        userAndLike.put("sharedate", sharedate );
	        userAndLike.put("number", number);
	        usersAndLikes.add(userAndLike);
	    }
	    return usersAndLikes;
	}
	
	public List<Users> getUserActive(Boolean active){
		String sql = "SELECT o FROM Users o WHERE o.active =?0";
		return super.findMany(Users.class, sql, active);
	}

	
	public static List<Integer> getYearRegister(){
		String sql = "SELECT YEAR(o.starday) FROM Users o Group by YEAR(o.starday)";
		TypedQuery<Integer> query = em.createQuery(sql,Integer.class);
		return query.getResultList();
	}
	public List<Users> getbyKeywork(Integer active, String title,Integer year){
		String key = "%"+title+"%";
		String s ,y ="";
		if(year !=-1) {
			y = " and YEAR(o.starday) = "+year;
		}
		if(active <0) {
			s = "o.active =0 And";
		}else if(active==1) {
			s = "o.active =1 And";
		}else {
			s = "";
		}
		String sql = "select o from Users o where "+s+" o.username like ?0 or o.email like ?1 or o.fullname like ?2 "+ y;
		return super.findMany(Users.class, sql,key,key,key);
	}


}
