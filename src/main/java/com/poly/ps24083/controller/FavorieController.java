package com.poly.ps24083.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
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
import javax.servlet.http.Part;

import com.poly.ps24083.empl.FavoriteImpl;
import com.poly.ps24083.empl.ShareImpl;
import com.poly.ps24083.empl.UserDaoImpl;
import com.poly.ps24083.empl.VideoImlpl;
import com.poly.ps24083.enity.Users;
import com.poly.ps24083.enity.Video;
import com.poly.ps24083.service.SessionAtrb;

/**
 * Servlet implementation class FavorieController
 */
@MultipartConfig()
@WebServlet({ "/Favorite", "/editAccount", "/changepass" })
public class FavorieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FavoriteImpl videodao = new FavoriteImpl();
	VideoImlpl videoshare = new VideoImlpl();
	UserDaoImpl udao = new UserDaoImpl();
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	public FavorieController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = request.getRequestURI();
		if (url.contains("Favorite")) {
			dofavorite(session, request, response);
		} else if (url.contains("editAccount")) {
			doeditAccount(session, request, response);
		} else if (url.contains("changepass")) {
			dochangPass(request, response);
		}
	}

	private void dochangPass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/jsp/changePass.jsp").forward(request, response);
	}

	private void doeditAccount(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Users user = (Users) session.getAttribute(SessionAtrb.Current_User);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/views/jsp/editAccount.jsp").forward(request, response);

	}

	private void dofavorite(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Users user = (Users) session.getAttribute(SessionAtrb.Current_User);
		List<Video> list = videodao.findAllVideoofUserfavorited(user.getId(), true);
		List<Video> listshare = videoshare.findUsersToShare(user.getId());
		request.setAttribute("user", user);
		request.setAttribute("list", list);
		request.setAttribute("listshare", listshare);
		request.getRequestDispatcher("/views/jsp/FavoriteVideo.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = request.getRequestURI();
		if (url.contains("Favorite")) {
			dofavorite(session, request, response);
		} else if (url.contains("editAccount")) {
			doPosteditAccount(session, request, response);
		} else if (url.contains("changepass")) {
			doPostchangPass(session, request, response);
		}
	}

	private void doPostchangPass(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		Users user = (Users) session.getAttribute(SessionAtrb.Current_User);
		String oldpass = request.getParameter("oldpass");
		String newpass = request.getParameter("newpass");
		String confirm = request.getParameter("confirm");
		boolean check = false;
		if (user.getPass().equalsIgnoreCase(oldpass)) {
			if (newpass.equalsIgnoreCase(confirm)) {
				user.setPass(newpass);
				check = udao.update(user);
				System.out.println("go");

			} else {
				request.setAttribute("error", "Xác Nhận Mật Khẩu Chưa Đúng");
			}
		} else {
			request.setAttribute("error", "Mật Khẩu Hiện Tại Chưa Đúng");
		}

		if (check) {
			response.sendRedirect("index");
		} else {
			request.setAttribute("oldpass", oldpass);
			request.setAttribute("newpass", newpass);
			request.setAttribute("confirm", confirm);
			request.getRequestDispatcher("/views/jsp/changePass.jsp").forward(request, response);
		}

	}

	private void doPosteditAccount(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Users user = (Users) session.getAttribute(SessionAtrb.Current_User);
		String fulname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String birth = request.getParameter("birth");
		user.setFullname(fulname);
		user.setEmail(email);
		try {
			user.setBirth(format.parse(birth));
		} catch (Exception e) {
			user.setBirth(new Date());
		}
		String img = SessionAtrb.writeFileImg(request, "img");
		if(img!=null) {
			user.setAvatar(img);
		}else {
			user.setAvatar(user.getAvatar());
		}
		boolean check = udao.update(user);
		if (check) {
			response.sendRedirect("index");
		} else {
			try {
				Users us = new Users();
				us.setFullname(fulname);
				us.setEmail(email);
				us.setBirth(format.parse(birth));
				us.setAvatar(user.getAvatar());
				request.setAttribute("user", us);
				request.getRequestDispatcher("/views/jsp/editAccount.jsp").forward(request, response);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

	}

}
