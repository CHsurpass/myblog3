package tzc.blog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tzc.blog.bean.Post;
import tzc.blog.dao.PostDao;

public class AdminPostController extends HttpServlet {

	public AdminPostController() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "textml;charset=utf-8");
			PostDao postDao = new PostDao();
			List<Post> posts = postDao.getAll();
			request.setAttribute("posts", posts);
			request.getRequestDispatcher("/admin_texts.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "textml;charset=utf-8");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String view = request.getParameter("view");
			
			if("true".equals(view)) {
				doGet(request, response);
				return;
			}
			if(title==null || "".equals(title)){
				request.setAttribute("error", "文章名称不能为空");
				doGet(request, response);
				return;
			}
			if(content==null || "".equals(content)){
				request.setAttribute("error", "文章内容不能为空");
				doGet(request, response);
				return;
			}

			PostDao postDao = new PostDao();
			boolean isExists = postDao.exists(title);
			if(isExists) {
				request.setAttribute("error","文章名称已存在");
				doGet(request, response);
				return;
			}
			postDao.addPost(title, content);
			doGet(request, response);
	}

}
