package tzc.blog.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tzc.blog.bean.Category;
import tzc.blog.bean.Post;
import tzc.blog.dao.PostDao;

public class AdminPostViewController extends HttpServlet {

	public AdminPostViewController() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			response.setHeader("content-type", "textml;charset=utf-8");
			String idsString = request.getParameter("id");
			int id = Integer.parseInt(idsString);
			PostDao postDao = new PostDao();
			Post post = postDao.get(id);
			request.setAttribute("post",post);
			request.getRequestDispatcher("/admin_post_view.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			response.setHeader("content-type", "textml;charset=utf-8");
			doGet(request, response);
	}

}
