package tzc.blog.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tzc.blog.bean.Post;
import tzc.blog.dao.PostDao;

public class AdminPostEditController extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AdminPostEditController() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "textml;charset=utf-8");
		String idsString = request.getParameter("id");
		int id = Integer.parseInt(idsString);
		PostDao postDao = new PostDao();
		Post post = postDao.get(id);
		request.setAttribute("post",post);
		request.getRequestDispatcher("/admin_post_edit.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "textml;charset=utf-8");
			String content = request.getParameter("content");
			int id = Integer.parseInt(request.getParameter("id"));
			if(content==null || "".equals(content)){
				request.setAttribute("error", "文章内容不能为空，请重新编辑");
				doGet(request, response);
				return;
			}
			PostDao postDao = new PostDao();
			postDao.edit(id, content);
			request.setAttribute("error", "编辑成功，已保存");
			doGet(request, response);
	}

}
