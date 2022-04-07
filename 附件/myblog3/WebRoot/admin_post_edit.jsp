<%@ page language ="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,tzc.blog.bean.*" %>
<%String base = request.getContextPath()+'/';%>
<html>
<head></head>
<body>
	<form action="<%=base %>admin/PostEdit" method="post">   
		<% Post post = (Post) request.getAttribute("post");%>
		<div align="center">
			<h2><%=post.getTitle()%><h2>
			<%String error = (String)request.getAttribute("error");
	        if(error!=null&&!"".equals(error)){%>
	        <div style="color:red" class="col-md-3"><%=error %></div>
	        <%}%>
			<textarea name = "content" align = "center" style="width:800px;height:600px" ><%=post.getContent() %></textarea>
		</div>
		<div class="contianer" >
	        <div align="center">
		        <input name="id" value="<%=post.getId() %>" type="hidden"/>
	            <button type="submit"><strong>修改</strong></button>
	        </div>
	    </div>
	</form>
	<div align="center">
        <a href="<%=base %>admin/Post"><button type="button" class="btn btn-w-m btn-info">返回</button></a>
    </div>
</body>
</html>
