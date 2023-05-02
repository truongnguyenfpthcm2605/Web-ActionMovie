package com.poly.ps24083.empl;

import java.util.List;

import com.poly.ps24083.dao.DAO;
import com.poly.ps24083.enity.GenreVideo;

public class GenreImpl extends DAO<GenreVideo> {
		
	public List<GenreVideo> findAll(){
		return super.findAll(GenreVideo.class, false);
	}
	
	public GenreVideo findbyid(Integer id) {
		return super.findByid(GenreVideo.class, id);
	}
	
	
}
