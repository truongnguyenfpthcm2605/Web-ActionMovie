package com.poly.ps24083.controller;

import java.io.IOException;
import java.io.Serial;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.poly.ps24083.empl.FavoriteImpl;
import com.poly.ps24083.empl.GenreImpl;
import com.poly.ps24083.empl.UserDaoImpl;
import com.poly.ps24083.empl.VideoImlpl;
import com.poly.ps24083.enity.GenreVideo;
import com.poly.ps24083.enity.Video;
import com.poly.ps24083.service.SessionAtrb;

/**
 * Servlet implementation class AddvideoControlller
 */
@MultipartConfig()
@WebServlet("/Addvideo")
public class AddvideoControlller extends HttpServlet {
	@Serial
	private static final long serialVersionUID = 1L;

	FavoriteImpl videodao = new FavoriteImpl();
	VideoImlpl videoshare = new VideoImlpl();
	UserDaoImpl udao = new UserDaoImpl();
	GenreImpl genre = new GenreImpl();

	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	List<Video> list;
	List<GenreVideo> listgenre = genre.findAll();
	Video video;

	public AddvideoControlller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String actionParams = request.getParameter("action");
		HttpSession session = request.getSession();
		session.setAttribute("film", "phimacdinh.png");

		switch (actionParams) {
		case "new":
			doNew(session, request, response);
			break;
		case "update":
			doupdate(session, request, response);
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + actionParams);
		}
	}

	private void doupdate(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session.setAttribute("add", "update");
		String link = request.getParameter("id");
		video = videoshare.findByLink(link);
		request.setAttribute("listgenre", listgenre);
		request.setAttribute("checktype", video.getGenre().getId());
		request.setAttribute("video", video);
		request.getRequestDispatcher("/views/jsp/addvideo.jsp").forward(request, response);
	}

	private void doNew(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session.setAttribute("add", "new");
		request.setAttribute("listgenre", listgenre);
		request.setAttribute("filmimg", (String) session.getAttribute("film"));
		request.getRequestDispatcher("/views/jsp/addvideo.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Video video = new Video();
		Integer idgenre = Integer.parseInt(request.getParameter("genreid"));
		String descript = request.getParameter("descriptions");
		String add = (String) request.getSession().getAttribute("add");
		if (descript == null) {
			descript = (String) request.getSession().getAttribute("des");
		}
		GenreVideo genres = genre.findbyid(idgenre);
		try {
			BeanUtils.populate(video, request.getParameterMap());
			video.setDescriptions(descript);
			video.setGenre(genres);
			String img = SessionAtrb.writeFileImg(request, "imgPoster");
			if (add.equals("update")) {
				video.setId((Integer) request.getSession().getAttribute("idvideo"));
				video.setViews((Integer) request.getSession().getAttribute("views"));
				if (img != null) {
					video.setPoster(img);
				} else {
					video.setPoster((String) request.getSession().getAttribute("img"));
				}
			} else {
				if (img != null) {
					video.setPoster(img);
				} else {
					video.setPoster((String) request.getSession().getAttribute("film"));
				}
				video.setViews(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean check = videodao.update(video);
		if (check) {
			response.sendRedirect("MangerVideo");
		} else {

			request.setAttribute("video", video);
			request.setAttribute("checktype", genres.getId());
			request.setAttribute("message", "Cập Nhật Thất Bại");
			request.setAttribute("listgenre", listgenre);
			request.getRequestDispatcher("/views/jsp/addvideo.jsp").forward(request, response);
		}

	}

}
