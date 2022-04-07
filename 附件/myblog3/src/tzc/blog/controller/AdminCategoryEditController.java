package tzc.blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tzc.blog.bean.Category;
import tzc.blog.dao.CategoryDao;

public class AdminCategoryEditController extends HttpServlet {

	public AdminCategoryEditController() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "textml;charset=utf-8");
			String idsString = request.getParameter("id");
			int id = Integer.parseInt(idsString);
			CategoryDao categoryDao = new CategoryDao();
			Category category = categoryDao.get(id);
			request.setAttribute("category",category);
			request.getRequestDispatcher("/admin_category_edit.jsp").forward(request, response);
			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "textml;charset=utf-8");
			String title = request.getParameter("title");
			int id = Integer.parseInt(request.getParameter("id"));
			
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
			categoryDao.edit(id, title);
			response.sendRedirect(request.getContextPath()+"/admin/Category");
	}

}
