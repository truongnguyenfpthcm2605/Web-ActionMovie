package com.poly.ps24083.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poly.ps24083.empl.FavoriteImpl;
import com.poly.ps24083.empl.VideoImlpl;
import com.poly.ps24083.enity.Video;
import com.poly.ps24083.service.SessionAtrb;

/**
 * Servlet implementation class HomeAllController
 */
@WebServlet({"/HomeAllController", "/HomePage"})
public class HomeAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int pageMaxsize = 8;
	FavoriteImpl videodao = new FavoriteImpl();
	VideoImlpl videoshare = new VideoImlpl();
    public HomeAllController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		HttpSession session = request.getSession();
		if(url.contains("HomeAllController")) {
			doHomeAll(session,request,response);
		}else {
			doPage(session,request, response);
		}
	}

	private void doHomeAll(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {		
		String title = request.getParameter("search");
		session.setAttribute("title", title); 
		Integer genreid = Integer.parseInt(request.getParameter("genres"));
		session.setAttribute("geres", genreid);
		List<Video> list ;
		if(genreid!=0) {
			list = videodao.findbyTitleGenre(title, genreid,true);
		}else {
			list = videodao.findbyTitle(title,true);
		}
		if(list.size()>0) {
			request.setAttribute("name",  title + "\n <i class='bx bx-search'></i>");
		}else {
			request.setAttribute("name", "Không Có Kết Quả  <i class='bx bx-search'></i>");
		}
		request.setAttribute("list", list);
		request.setAttribute("number", list.size());
	
		request.getRequestDispatcher("/views/jsp/PageAll.jsp").forward(request, response);
	
		
	}
	private void doPage(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer pagenumber =Integer.parseInt( request.getParameter("page"));
		int genreid = (int)session.getAttribute("geres");
		String title =(String)session.getAttribute("title");
		 int maxpage;
		List<Video> list;
		List<Video> vieos;
		if(genreid==0) {
			list = videodao.findbyTitle(title,true);
			maxpage = (int)Math.ceil(list.size()/(double)pageMaxsize);
			vieos = videoshare.pageVideoNumberTitle(pagenumber, pageMaxsize, title);
		}else {
			list = videodao.findbyTitleGenre(title, genreid,true);
			maxpage = (int)Math.ceil(list.size()/(double)pageMaxsize);
			vieos = videoshare.pageVideoNumberTitleByGenre(pagenumber, pageMaxsize,genreid, title);
		}
		
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("curentpage", pagenumber);
		if(maxpage < pagenumber) {
			pagenumber =1;
		}
		request.setAttribute("list", vieos);
		request.getRequestDispatcher("/views/jsp/PageAll.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
