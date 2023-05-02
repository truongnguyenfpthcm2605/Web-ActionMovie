package com.poly.ps24083.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.ps24083.empl.VideoImlpl;
import com.poly.ps24083.enity.Video;
import com.poly.ps24083.service.SessionAtrb;

/**
 * Servlet implementation class HomePageController
 */
@WebServlet("/HomePageController")
public class HomePageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private static final int pageMaxsize = 8;
      VideoImlpl videodao = new VideoImlpl();

    public HomePageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer pagenumber =Integer.parseInt( request.getParameter("page"));
		
		Integer gereid = Integer.parseInt(request.getParameter("genre"));
		request.setAttribute("name", SessionAtrb.getNameGenre(gereid));
		List<Video> videoall = videodao.findVideoGenreAll(gereid);
		// tinh max page
		int maxpage = (int)Math.ceil(videoall.size()/(double)pageMaxsize);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("curentpage", pagenumber);
		if(maxpage < pagenumber) {
			pagenumber =1;
		}
		List<Video> videos =videodao.pageVideoNumber(pageMaxsize, pagenumber, gereid);
		request.setAttribute("list", videos);
		request.getRequestDispatcher("/views/jsp/page.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
