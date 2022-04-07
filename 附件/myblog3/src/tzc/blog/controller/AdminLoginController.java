package tzc.blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tzc.blog.dao.UserDao;

public class AdminLoginController extends HttpServlet {

	public AdminLoginController() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "textml;charset=utf-8");
		request.getRequestDispatcher("/admin_login.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "textml;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDao userDao = new UserDao();
		boolean valid = false;
		valid = userDao.isValid(username, password);
		if(valid) {
			response.sendRedirect("admin/Home");
			return;
		}
		else {
			request.setAttribute("error", "用户名或密码错误");
			doGet(request, response);
		}
	}

}
