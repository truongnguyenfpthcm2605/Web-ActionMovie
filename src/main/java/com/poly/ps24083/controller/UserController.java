package com.poly.ps24083.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.poly.ps24083.empl.UserDaoImpl;
import com.poly.ps24083.enity.Users;
import com.poly.ps24083.service.CookieUtils;
import com.poly.ps24083.service.SessionAtrb;
import com.poly.ps24083.service.Util;

@WebServlet({ "/login", "/logout", "/register", "/forgotpass" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDaoImpl userdao = new UserDaoImpl();
	Util vl = new Util();
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	CookieUtils cookie = new CookieUtils();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String path = request.getServletPath();
		switch (path) {
		case "/login":
			doLogin(request, response);
			break;
		case "/logout":
			doLogout(session, request, response);
			break;
		case "/register":
			doRegister(request, response);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + path);
		}

	}

	private void doPostLogin(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean svaecookie = Boolean.parseBoolean(request.getParameter("checklogin"));
		Users user = userdao.findByUser(username, password);

		if (user != null) {
			session.setAttribute(SessionAtrb.Current_User, user);
			if (svaecookie) {
				CookieUtils.add(username, password, 1, response);
			} else {
				CookieUtils.add(username, password, 0, response);
			}
			response.sendRedirect("index");
		} else {
			request.setAttribute("message", "Đăng Nhập Thất Bại");
			request.getRequestDispatcher("/views/jsp/login.jsp").forward(request, response);
		}
	}

	private void doPostRegister(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String birth = request.getParameter("birthday");
			Users newUs = new Users();
			BeanUtils.populate(newUs, request.getParameterMap());
			newUs.setBirth(format.parse(birth));
			newUs.setVip(0);
			newUs.setAdmin(false);
			newUs.setAvatar("avt.png");
			newUs.setActive(true);
			if(userdao.findbyUsername(newUs.getUsername())!=null) {
				request.setAttribute("errorUsername", "Username đã tồn tại");
				request.setAttribute("user", newUs);
				request.getRequestDispatcher("/views/jsp/register.jsp").forward(request, response);
			}else {
				boolean check = userdao.insert(newUs);
				if (check) {
					session.setAttribute(SessionAtrb.Current_User, newUs);
					response.sendRedirect("index");
				} else {
					doRegister(request, response);
				}
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cs = request.getCookies();
		for (Cookie c : cs) {
			if (c.getName().equals("username")) {
				request.setAttribute("user", c.getValue());
			} else if (c.getName().equals("password")) {
				request.setAttribute("pass", c.getValue());
			}
		}
		request.getRequestDispatcher("/views/jsp/login.jsp").forward(request, response);
	}

	private void doRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/jsp/register.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String path = request.getServletPath();
		switch (path) {
		case "/login":
			doPostLogin(session, request, response);
			break;
		
		case "/register":
			doPostRegister(session, request, response);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + path);
		}
	}

	protected void doLogout(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session.removeAttribute(SessionAtrb.Current_User);
		response.sendRedirect("index");
	}

}
