package com.poly.ps24083.empl;

import java.util.Date;
import java.util.List;

import com.poly.ps24083.dao.DAO;
import com.poly.ps24083.enity.Share;
import com.poly.ps24083.enity.Users;
import com.poly.ps24083.enity.Video;

public class ShareImpl  extends DAO<Share> {
	
	public List<Share> findAll(){
		return super.findAll(Share.class, false);
	}
	
	public boolean updateShare(Share enity) {
		return super.insert(enity);
	}
	
	public boolean insert(Video video , Users user) {
		Share s = new Share();
		s.setEmails(user.getEmail());
		s.setSharedate(new Date());
		s.setVideo(video);
		s.setUser(user);
		s.setNumber(1);
		return super.insert(s);
		
	}
	public Share findUsershareVideo(Integer usid , Integer videoid) {
		String sql = " select o from  Share o where o.user.id = ?0 and o.video.id= ?1";
		return super.findOne(Share.class, sql, usid,videoid);
	}
	
}
