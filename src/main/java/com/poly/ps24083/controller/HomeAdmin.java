package com.poly.ps24083.controller;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.annotations.Check;

import com.poly.ps24083.empl.FavoriteImpl;
import com.poly.ps24083.empl.GenreImpl;
import com.poly.ps24083.empl.UserDaoImpl;
import com.poly.ps24083.empl.VideoImlpl;
import com.poly.ps24083.enity.GenreVideo;
import com.poly.ps24083.enity.Users;
import com.poly.ps24083.enity.Video;
import com.poly.ps24083.service.SessionAtrb;

/**
 * Servlet implementation class HomeAdmin
 */
@MultipartConfig()
@WebServlet({ "/MangerVideo", "/deleteVideo", "/UnActive", "/Active", "/restoreVideo" })
public class HomeAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FavoriteImpl videodao = new FavoriteImpl();
	VideoImlpl videoshare = new VideoImlpl();
	UserDaoImpl udao = new UserDaoImpl();
	GenreImpl genre = new GenreImpl();

	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	List<Video> list;
	List<GenreVideo> listgenre = genre.findAll();
	Video video;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().setAttribute("active", true);
		list = videoshare.findAll(Video.class, true);
		String path = request.getRequestURI();
		if (path.contains("UnActive")) {
			list = videoshare.findVideoUnActive();
			request.getSession().setAttribute("active", false);

		} else if (path.contains("deleteVideo")) {
			doDeleteVideo(request, response);
		}

		else if (path.contains("restoreVideo")) {
			dorestoreVideo(request, response);
		}

		request.setAttribute("list", list);
		request.setAttribute("listgenre", listgenre);
		request.getRequestDispatcher("/views/jsp/AdminManager.jsp").forward(request, response);

	}

	private void dorestoreVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Video video = videoshare.findByLink(request.getParameter("id"));
		video.setActive(true);
		videoshare.update(video);
		if (!(boolean) request.getSession().getAttribute("active")) {
			list = videoshare.findAll(Video.class, true);
		} else {
			list = videoshare.findVideoUnActive();
		}
		request.setAttribute("list", list);
		request.setAttribute("listgenre", listgenre);
		request.getRequestDispatcher("/views/jsp/AdminManager.jsp").forward(request, response);

	}

	private void doDeleteVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Video video = videoshare.findByLink(request.getParameter("id"));
		video.setActive(false);
		videoshare.update(video);
		if (!(boolean) request.getSession().getAttribute("active")) {
			list = videoshare.findAll(Video.class, true);
		} else {
			list = videoshare.findVideoUnActive();
		}

		request.setAttribute("list", list);
		request.setAttribute("listgenre", listgenre);
		request.getRequestDispatcher("/views/jsp/AdminManager.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer genreid = Integer.parseInt(request.getParameter("typeMovie"));
		Boolean active = (Boolean) request.getSession().getAttribute("active");
		int check = genreid;
		String title = request.getParameter("searchfilm");
		if (genreid > 0) {
			list = videodao.findbyTitleGenre(title, genreid, active);
		} else {
			list = videodao.findbyTitle(title, active);
		}
		if (list.size() > 0) {
			request.setAttribute("name", title + "\n <i class='bx bx-search'></i>");
		} else {
			request.setAttribute("name", "Không Có Kết Quả" + "<i class='bx bx-search'></i>");
		}

		request.setAttribute("check", check);
		request.setAttribute("list", list);
		request.setAttribute("listgenre", listgenre);
		request.getRequestDispatcher("/views/jsp/AdminManager.jsp").forward(request, response);

	}

}
