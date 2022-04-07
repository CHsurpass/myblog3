<%@ page language ="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%String base = request.getContextPath()+'/';%>
	
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>博客管理后台 | Dashboard v.2</title>

    <link href="<%=base %>css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=base %>font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="<%=base %>css/animate.css" rel="stylesheet">
    <link href="<%=base %>css/style.css" rel="stylesheet">

</head>

<body>
    <div id="wrapper">
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav metismenu" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element"> <span>
                            <img height="46px" width="53px" alt="image" class="img-circle" src="<%=base %>img/gg.jpg" />
                             </span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">GG</strong>
                             </span>  </span> </a>
                        
                    </div>
                    <div class="logo-element">
                        IN+
                    </div>
                </li>
                
                <li>
                    <a href="<%=base %>admin/Home"><i class="fa fa-diamond"></i> <span class="nav-label">首页</span></a>
                </li>
                <li>
                    <a href="<%=base %>admin/Category"><i class="fa fa-pie-chart"></i> <span class="nav-label">分类管理</span>  </a>
                </li>
                <li>
                    <a href="<%=base %>admin/Post"><i class="fa fa-flask"></i> <span class="nav-label">文章管理</span></a>
                </li>
                
            </ul>

        </div>
    </nav>

        <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
        <nav class="navbar navbar-static-top white-bg" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
            
        </div>
            <ul class="nav navbar-top-links navbar-right">
                <li>
                    <span class="m-r-sm text-muted welcome-message">欢迎来到博客后台</span>
                </li>
                
                


                <li>
                    <a href="<%=base%>Login">
                        <i class="fa fa-sign-out"></i> Log out
                    </a>
                </li>
                
            </ul>

        </nav>
        </div>
            <div class="wrapper wrapper-content">
        <tbody>
        	<tr>
	        	<td>
					<table align="center" style="width:980px">
					    <tbody>
					    	<tr>
					      		<td>
									<img src="<%=base %>img/tt.jpg" style="width:1000px;height:150px">
						 	 	</td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
		</tbody>
        
            </div>
        
        </div>
        
    </div>
	<div class="contianer" >
		<div class="pull-right">
        	<%=new java.util.Date() %>
        </div>
        <div align="center">
            <strong>Copyright</strong> R1ST &copy; 2021
        </div>
    </div>
    <!-- Mainly scripts -->
    <script src="<%=base %>js/jquery-2.1.1.js"></script>
    <script src="<%=base %>js/bootstrap.min.js"></script>
    <script src="<%=base %>js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="<%=base %>js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

    <!-- Flot -->
    <script src="<%=base %>js/plugins/flot/jquery.flot.js"></script>
    <script src="<%=base %>js/plugins/flot/jquery.flot.tooltip.min.js"></script>
    <script src="<%=base %>js/plugins/flot/jquery.flot.spline.js"></script>
    <script src="<%=base %>js/plugins/flot/jquery.flot.resize.js"></script>
    <script src="<%=base %>js/plugins/flot/jquery.flot.pie.js"></script>
    <script src="<%=base %>js/plugins/flot/jquery.flot.symbol.js"></script>
    <script src="<%=base %>js/plugins/flot/jquery.flot.time.js"></script>

    <!-- Peity -->
    <script src="<%=base %>js/plugins/peity/jquery.peity.min.js"></script>
    <script src="<%=base %>js/demo/peity-demo.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="<%=base %>js/inspinia.js"></script>
    <script src="<%=base %>js/plugins/pace/pace.min.js"></script>

    <!-- jQuery UI -->
    <script src="<%=base %>js/plugins/jquery-ui/jquery-ui.min.js"></script>

    <!-- Jvectormap -->
    <script src="<%=base %>js/plugins/jvectormap/jquery-jvectormap-2.0.2.min.js"></script>
    <script src="<%=base %>js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>

    <!-- EayPIE -->
    <script src="<%=base %>js/plugins/easypiechart/jquery.easypiechart.js"></script>

    <!-- Sparkline -->
    <script src="<%=base %>js/plugins/sparkline/jquery.sparkline.min.js"></script>

    <!-- Sparkline demo data  -->
    <script src="<%=base %>js/demo/sparkline-demo.js"></script>

</body>
</html>
