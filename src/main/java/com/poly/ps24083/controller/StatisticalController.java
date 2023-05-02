package com.poly.ps24083.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.ps24083.empl.FavoriteImpl;
import com.poly.ps24083.empl.GenreImpl;
import com.poly.ps24083.empl.UserDaoImpl;
import com.poly.ps24083.empl.VideoImlpl;
import com.poly.ps24083.enity.Users;
import com.poly.ps24083.enity.Video;

/**
 * Servlet implementation class StatisticalController
 */
@WebServlet({ "/VideoFavorite", "/VideoShare", "/Videoview", "/VideoUserFavorite", "/VieoFavoriteAndSahre",
		"/personLike","/personShare" })
public class StatisticalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FavoriteImpl videodao = new FavoriteImpl();
	VideoImlpl videoshare = new VideoImlpl();
	UserDaoImpl udao = new UserDaoImpl();
	GenreImpl genre = new GenreImpl();
	List<Video> listVieoFavorite;
	List<Video> listVieoShare;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StatisticalController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		String path;
		if (url.contains("VideoFavorite")) {
			path = "/views/jsp/VideoFavorite.jsp";
			doVideoFavorite(path, request, response);

		} else if (url.contains("VideoShare")) {
			path = "/views/jsp/VideoShare.jsp";
			doVideoShare(path, request, response);

		} else if (url.contains("Videoview")) {
			path = "/views/jsp/Videoview.jsp";
			doVideoView(path, request, response);

		} else if (url.contains("VideoUserFavorite")) {
			path = "/views/jsp/VideoUserFavorite.jsp";
			doVideoUserFavorite(path, request, response);

		} else if (url.contains("VieoFavoriteAndSahre")) {
			path = "/views/jsp/VieoFavoriteAndSahre.jsp";
			doVieoFavoriteAndSahre(path, request, response);
			
		} else if (url.contains("personLike")) {
			path = "/views/jsp/personLike.jsp";
			doPersonLike(path, request, response);
			
		} else if (url.contains("personShare")) {
			path = "/views/jsp/personShare.jsp";
			dopersonShare(path, request, response);
		}
		
	}

	private void dopersonShare(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer idvideo = Integer.parseInt(request.getParameter("id"));
		String filmName = videoshare.findById(idvideo).getTitle();
		 List<Map<String, Object>> usersAndLikes = udao.findAllUserToShareVideoDate(idvideo);
		request.setAttribute("list", usersAndLikes);
		request.setAttribute("view", path);
		request.setAttribute("film", filmName);
		request.getRequestDispatcher("/views/jsp/statistical.jsp").forward(request, response);
		
	}

	private void doVieoFavoriteAndSahre(String path, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Video> list = videoshare.findAll();
		request.setAttribute("view", path);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/jsp/statistical.jsp").forward(request, response);

	}

	private void doVideoUserFavorite(String path, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Video> list = videoshare.findAll();
		request.setAttribute("view", path);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/jsp/statistical.jsp").forward(request, response);

	}

	private void doVideoView(String path, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Video> list = videodao.findByview();
		request.setAttribute("view", path);
		request.setAttribute("listVieoView", list);
		request.getRequestDispatcher("/views/jsp/statistical.jsp").forward(request, response);

	}

	private void doVideoShare(String path, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Boolean check = Boolean.parseBoolean(request.getParameter("action"));
		listVieoShare = videodao.getVideoShareOrNot(true);
		if (check != null) {
			listVieoShare = videodao.getVideoShareOrNot(check);
		}
		request.setAttribute("view", path);
		request.setAttribute("listVieoShare", listVieoShare);
		request.getRequestDispatcher("/views/jsp/statistical.jsp").forward(request, response);

	}

	private void doVideoFavorite(String path, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Boolean check = Boolean.parseBoolean(request.getParameter("action"));
		listVieoFavorite = videodao.getVideoFavoriteOrNot(true);
		if (check != null) {
			listVieoFavorite = videodao.getVideoFavoriteOrNot(check);
		}
		request.setAttribute("view", path);
		request.setAttribute("listVieoFavorite", listVieoFavorite);
		request.getRequestDispatcher("/views/jsp/statistical.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getRequestURI();
		String path;
		if (url.contains("VideoUserFavorite")) {
			path = "/views/jsp/VideoUserFavorite.jsp";
			doPostVideoUserFavorite(path, request, response);

		} else if (url.contains("VieoFavoriteAndSahre")) {
			path = "/views/jsp/VieoFavoriteAndSahre.jsp";
			doPostVieoFavoriteAndSahre(path, request, response);

		}

	}

	private void doPersonLike(String path, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer idvideo = Integer.parseInt(request.getParameter("id"));
		String filmName = videoshare.findById(idvideo).getTitle();
		 List<Map<String, Object>> usersAndLikes = udao.findAllUserToFavoriteVideoDate(idvideo);
		request.setAttribute("list", usersAndLikes);
		request.setAttribute("view", path);
		request.setAttribute("film", filmName);
		request.getRequestDispatcher("/views/jsp/statistical.jsp").forward(request, response);

	}

	private void doPostVieoFavoriteAndSahre(String path, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("titlevideo");
		List<Video> list = videoshare.findTitleVideo(title);
		request.setAttribute("view", path);
		request.setAttribute("key", title);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/jsp/statistical.jsp").forward(request, response);

	}

	private void doPostVideoUserFavorite(String path, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Video> list;
		Integer iduser = 0;
		try {
			iduser = Integer.parseInt(request.getParameter("iduserfavorite"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (iduser != 0) {
			list = videodao.findAllVideoofUserfavorited(iduser, true);
		} else {
			list = videoshare.findAll();
		}
		Users usfind = udao.findByID(iduser);
		if (usfind != null) {
			request.setAttribute("message", usfind.getFullname() + "<i class='bx bx-search'></i>");
		} else {
			request.setAttribute("message", " Người dùng không tồn tại <i class='bx bx-meh-alt'></i>");
		}
		request.setAttribute("view", path);
		request.setAttribute("key", iduser);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/jsp/statistical.jsp").forward(request, response);

	}

}
