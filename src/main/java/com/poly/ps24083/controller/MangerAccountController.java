package com.poly.ps24083.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.ps24083.empl.UserDaoImpl;
import com.poly.ps24083.enity.Users;
import com.poly.ps24083.service.ExcelUtil;

/**
 * Servlet implementation class MangerAccountController
 */
@WebServlet({ "/MangerAccount", "/DeleteAccount", "/restoreAccount", "/AccountUnActive", "/AccountActive" })
public class MangerAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDaoImpl udao = new UserDaoImpl();
	List<Integer> years = UserDaoImpl.getYearRegister();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MangerAccountController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();

		switch (path) {
		case "/MangerAccount":
			doAccount(request, response);
			break;
		case "/DeleteAccount":
			doDeleteAccount(request, response);
			break;
		case "/restoreAccount":
			doRestoreAccount(request, response);
			break;
		case "/AccountUnActive":
			doAccountUnActive(request, response);
			break;
		case "/AccountActive":
			doAccountActive(request, response);
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + path);
		}
	}



	private void doAccountActive(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Users> list = udao.getUserActive(true);
		request.getSession().setAttribute("account", 1);
		request.setAttribute("list", list);
		request.setAttribute("years", years);
		request.getRequestDispatcher("/views/jsp/Account.jsp").forward(request, response);

	}

	private void doAccountUnActive(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Users> list = udao.getUserActive(false);
		request.getSession().setAttribute("account", -1);
		request.setAttribute("list", list);
		request.setAttribute("years", years);
		request.getRequestDispatcher("/views/jsp/Account.jsp").forward(request, response);

	}

	private void doRestoreAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Users us = udao.findByID(id);
		us.setActive(true);
		udao.update(us);
		response.sendRedirect("MangerAccount");
	}

	private void doAccount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		exportExcel();
		List<Users> list = udao.findAll(Users.class, false);
		request.getSession().setAttribute("account", 0);
		request.setAttribute("list", list);
		request.setAttribute("years", years);
		request.getRequestDispatcher("/views/jsp/Account.jsp").forward(request, response);

	}

	private void doDeleteAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Users us = udao.findByID(id);
		us.setActive(false);
		udao.update(us);
		response.sendRedirect("MangerAccount");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keywork = request.getParameter("searchAccount");
		Integer year = Integer.parseInt(request.getParameter("year"));
		int check = year;
		Integer active = (int) request.getSession().getAttribute("account");
		System.out.println(active);
		List<Users> list = udao.getbyKeywork(active, keywork, year);
		request.setAttribute("list", list);
		request.setAttribute("years", years);
		request.setAttribute("check", check);
		request.setAttribute("key", keywork);
		request.getRequestDispatcher("/views/jsp/Account.jsp").forward(request, response);

	}

	private  void exportExcel() {
		try {
			List<Users> list = udao.findAll(Users.class, false);
			String[] herdear = { "Stt", "ID", "Username", "Fuulname", "Birth", "Avatar", "Starday", "Vip", "Email",
					"Role", "Active" };
			String exportPath = "/Export/Account.xlsx";
			String absolutePath = getServletContext().getRealPath("/") + exportPath;
			ExcelUtil.writeExcel(absolutePath, list, "Account", herdear);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
