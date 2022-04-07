package tzc.blog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import tzc.blog.bean.Category;
import tzc.blog.dao.CategoryDao;

public class AdminCategoryController extends HttpServlet {


	public AdminCategoryController() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "textml;charset=utf-8");
			CategoryDao categoryDao = new CategoryDao();
			List<Category> categories = categoryDao.getAll();
			request.setAttribute("categories", categories);

			request.getRequestDispatcher("/admin_category.jsp").forward(request, response);
			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			response.setHeader("content-type", "textml;charset=utf-8");

			String title = request.getParameter("title");
			if(title==null || "".equals(title)){
				request.setAttribute("error", "分类名称不能为空");
				doGet(request, response);
				return;
			}
			
			CategoryDao categoryDao = new CategoryDao();
			
			boolean isExists = categoryDao.exists(title);
			if(isExists) {
				request.setAttribute("error","分类名称已存在");
				doGet(request, response);
				return;
			}
			categoryDao.addCategory(title);
			doGet(request, response);
	}
	
}
