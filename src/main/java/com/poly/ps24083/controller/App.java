package com.poly.ps24083.controller;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.ps24083.empl.VideoImlpl;
import com.poly.ps24083.enity.Video;

@WebServlet("/index")
public class App extends HttpServlet {
	VideoImlpl videodao = new VideoImlpl();

	@Serial
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Video> filmaction  = videodao.findVideoGenre(1);
		List<Video> filmlove  = videodao.findVideoGenre(2);
		List<Video> filmkinhdi  = videodao.findVideoGenre(3);
		List<Video> filmfiction  = videodao.findVideoGenre(4);
		List<Video> filmanime  = videodao.findVideoGenre(5);
		request.setAttribute("filmaction", filmaction);
		request.setAttribute("filmlove", filmlove);
		request.setAttribute("filmanime", filmanime);
		request.setAttribute("filmkinhdi", filmkinhdi);
		request.setAttribute("filmfiction", filmfiction);
		request.getRequestDispatcher("/views/jsp/index.jsp").forward(request, response);
	}

}
