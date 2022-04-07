<%@ page language ="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,tzc.blog.bean.*" %>
<%String base = request.getContextPath()+'/';%>
<html>
<head></head>
<body>
	<form action="<%=base %>admin/Post" method="post">   
		<% Post post = (Post) request.getAttribute("post");%>
		<div class="content" align="center">
			<h2><%=post.getTitle()%><h2>
			<textarea name = "content" align = "center" style="width:800px;height:600px" ><%=post.getContent() %></textarea>
		
		</div>

		<div class="contianer" >
	        <div align="center">
		        <input name="view" value="true" type="hidden"/>
	            <button type="submit"><strong>返回</strong></button>
	        </div>
	    </div>		
	</form>
</body>
</html>
