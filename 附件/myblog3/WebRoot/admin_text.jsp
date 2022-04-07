<%@ page language ="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%String base = request.getContextPath()+'/';%>
<!DOCTYPE html>
<html>
<head></head>
<body>
	<form action="<%=base %>admin/Post" method="post">           		
		<div align = "center"><td>文章名称</td>:<td><input type="text" name="title"></td></div>
		<br/>
		<div align="center"><h3>内容</h3></div>
		<div align="center">
		
			<textarea name="content"  style="width:800px;height:600px" ></textarea> 
		</div>
		<br/>
		<div align="center"><button ><h3>添加文章</h3></button></div>						
	</form>
</body>
</html>
