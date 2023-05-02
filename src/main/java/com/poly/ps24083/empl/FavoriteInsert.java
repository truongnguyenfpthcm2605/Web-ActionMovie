package com.poly.ps24083.empl;

import java.util.Date;
import java.util.List;

import com.poly.ps24083.dao.DAO;
import com.poly.ps24083.enity.Favorite;
import com.poly.ps24083.enity.Users;
import com.poly.ps24083.enity.Video;

public class FavoriteInsert extends DAO<Favorite> {
	VideoImlpl vimpl = new VideoImlpl();
	FavoriteImpl fimpl = new FavoriteImpl();

	public boolean insert(Video video, Users user) {
		Favorite f = new Favorite();
		f.setActive(false);
		f.setUser(user);
		f.setVideo(video);
		f.setLikedate(new Date());
		return super.insert(f);
	}

	public boolean update(Favorite enity) {
		return super.update(enity);
	}
	


	public List<Favorite> findAll() {
		return super.findAll(Favorite.class, true);
	}

	public Favorite getFavoriteHaveUserandVideoid(Integer usid, Integer videoid) {
		String sql = "SELECT o FROM Favorite o WHERE o.user.id = ?0 AND o.video.id = ?1";
		return super.findOne(Favorite.class, sql, usid, videoid);
	}

	public boolean updateLikeandUnLike(Users us, String link) {

		Video video = vimpl.findByLink(link);
		Favorite f = getFavoriteHaveUserandVideoid(us.getId(), video.getId());
			if (f.getActive()) {
				f.setActive(false);
				f.setLikedate(null);
			} else {
				f.setActive(true);
				f.setLikedate(new Date());

			}
		 boolean check = update(f);

		return check;

	}
}
