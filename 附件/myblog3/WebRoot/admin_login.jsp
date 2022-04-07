<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>	R1ST的博客 | Login</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen animated fadeInDown">
        <div>
            <div>
                <h1 class="logo-name">AC☆</h1>
            </div>
            <h3>欢迎来到AC☆</h3>
           	<%String error = (String)request.getAttribute("error");
           	if(error!=null&&!"".equals(error)) {
           	%>
           	<p style="color:red"><%=error %></p>
           	<%} %>
            <form class="m-t" role="form" action="Login" method ="post">
                <div class="form-group">
                    <input name="username" type="text" class="form-control" placeholder="账号" required="">
                </div>
                <div class="form-group">
                    <input name="password" type="password" class="form-control" placeholder="密码" required="">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">登录</button>
			</form>
            <p class="m-t"> <small>R1ST &copy; 2021</small> </p>
        </div>
    </div>

    <!-- Mainly scripts -->
    <script src="js/jquery-3.1.1.js"></script>
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
