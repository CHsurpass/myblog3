package tzc.blog.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tzc.blog.bean.Category;
import tzc.blog.dao.CategoryDao;

public class AdminCategoryDeleteController extends HttpServlet {


	public AdminCategoryDeleteController() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "textml;charset=utf-8");
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "textml;charset=utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		CategoryDao categoryDao = new CategoryDao();
		categoryDao.delete(id);
		response.sendRedirect(request.getContextPath()+"/admin/Category");
	}

}
