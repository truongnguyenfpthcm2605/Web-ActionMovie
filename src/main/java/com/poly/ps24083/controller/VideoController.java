package com.poly.ps24083.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poly.ps24083.empl.FavoriteInsert;
import com.poly.ps24083.empl.ShareImpl;
import com.poly.ps24083.empl.VideoImlpl;
import com.poly.ps24083.enity.Favorite;
import com.poly.ps24083.enity.Share;
import com.poly.ps24083.enity.Users;
import com.poly.ps24083.enity.Video;
import com.poly.ps24083.service.SendMail;
import com.poly.ps24083.service.SessionAtrb;

/**
 * Servlet implementation class VideoController
 */
@WebServlet("/Video")
public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VideoImlpl videodao = new VideoImlpl();
	FavoriteInsert fadao = new FavoriteInsert();
	ShareImpl sharedao = new ShareImpl();

	public VideoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String actionParams = request.getParameter("action");
		String link = request.getParameter("id");
		HttpSession session = request.getSession();

		switch (actionParams) {
		case "watch":
			dowatch(session, link, request, response);
			break;
		case "like":
			dofavorite(session, link, request, response);
			break;
		case "share":
			doShare(session, link, request, response);
			break;
		case "delete":
			doDelete(session, link, request, response);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + actionParams);
		}

	}

	private void doDelete(HttpSession session, String link, HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Users user = (Users) session.getAttribute(SessionAtrb.Current_User);
		Video video = videodao.findByLink(link);
		Favorite favorie = fadao.getFavoriteHaveUserandVideoid(user.getId(), video.getId());
		favorie.setLikedate(null);
		favorie.setActive(false);
		fadao.update(favorie);
		response.sendRedirect("Favorite");
		
	}

	private void doShare(HttpSession session, String link, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Users user = (Users) session.getAttribute(SessionAtrb.Current_User);
		Video video = videodao.findByLink(link);
		Share share = sharedao.findUsershareVideo(user.getId(), video.getId());
		try {
			SendMail.sendmail(link, user.getEmail());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(share  != null) {
				share.setNumber(share.getNumber()+1);
				sharedao.update(share);
		}
		sharedao.insert(video, user);
		response.sendRedirect("Video?action=watch&id=" + link);

	}

	private void dofavorite(HttpSession session, String link, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		Users user = (Users) session.getAttribute(SessionAtrb.Current_User);
		boolean check = fadao.updateLikeandUnLike(user, link);
		if (check) {
			response.setStatus(204);
		} else {
			response.setStatus(400);
		}

	}

	private void dowatch(HttpSession session, String link, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Video video = videodao.findByLink(link);
		video.setViews(video.getViews()+1);
		videodao.update(video);
		request.setAttribute("video", video);
		List<Video> videogenre = videodao.findVideoGenre(video.getGenre().getId());
		Users user = (Users) session.getAttribute(SessionAtrb.Current_User);
		if (user != null) {
			Favorite f = fadao.getFavoriteHaveUserandVideoid(user.getId(), video.getId());
			if (f == null) {
				fadao.insert(video, user);
				Favorite fnew = fadao.getFavoriteHaveUserandVideoid(user.getId(), video.getId());
				request.setAttribute("flaglike", fnew.getActive());
			} else {
				request.setAttribute("flaglike", f.getActive());
				System.out.println(f.getActive());
			}
		}
		request.setAttribute("Listvideo", videogenre);
		request.getRequestDispatcher("/views/jsp/DetailMovie.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
