<html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!--<%-->
<!--String user_name="";-->
<!--Object obj=session.getAttribute("user");-->
<!--if(obj!=null){-->
<!--User u=(User)obj;-->
<!--user_name=u.getUserName();-->
<!--}-->
<!--else{-->
<!--response.getWriter().write("<script>alert('请先登录');location.href='login.jsp'</script>");-->
<!--//            response.sendRedirect("login.jsp");-->
<!--}-->
<!--%>-->
<head lang="en">
    <meta charset="UTF-8">
	<title>大学生社团管理系统</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Public.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Style.css"/>
</head>
<body>
    <header class="publicHeader">
        <h1>大学生社团管理系统</h1>
	    <div class="publicHeaderR">
	        <p>欢迎使用大学生社团管理系统。</p>
	    	<a href="${pageContext.request.contextPath}/user/logout">退出</a>
    	</div>
    </header>
	<section class="publicTime">
	    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
	</section>
	<section class="publicMain">
	    <div class="left">
		    <h2 class="leftH2"><span class="span1"></span>功能列表<span></span></h2>
			<nav>
			    <ul class="list">
				    <li><a href="${pageContext.request.contextPath}/pages/home.jsp">首页</a></li>
				    <li id="active"><a href="${pageContext.request.contextPath}/user/findAll">用户管理</a></li>
					<li><a href="${pageContext.request.contextPath}/assocation/findAll">社团信息管理</a></li>
					<li><a href="${pageContext.request.contextPath}/activity/findAll">社团活动管理</a></li>
					<li><a href="${pageContext.request.contextPath}/finance/findAll">社团财务管理</a></li>
				</ul>
			</nav>
		</div>
		<div class="right">
		    <div class="location">
				<span>位置：用户管理页面 >> 用户添加页面</span>
			</div>
			<div class="providerAdd">
			    <form action="${pageContext.request.contextPath}/user/addUser" method="post">
					<div>
					    <label for="userName">用户名称:</label>
						<input type="text" name="userName" id="userName"/>
					</div>
					<div>
					    <label>用户性别:</label>
						<select name="userSex">
						    <option value="男">男</option>
							<option value="女">女</option>
						</select>
						<span></span>
					</div>
					<div>
					    <label for="userGrade">用户年级:</label>
						<input type="text" name="userGrade" id="userGrade"/>
						<span></span>
					</div>
					<div>
					    <label for="userClass">用户专业:</label>
						<input type="text" name="userClass" id="userClass"/>
						<span></span>
					</div>
					<div>
					    <label for="userCollege">用户学院:</label>
						<input type="text" name="userCollege" id="userCollege"/>
						<span></span>
					</div>
					<div>
				        <label for="userAssocation">所属社团:</label>
						<input type="text" name="userAssocation" id="userAssocation"/>
						<span></span>
					</div>
					<div>
                    <label for="userPassword">登录密码:</label>
                    <input type="text" name="userPassword" id="userPassword"/>

                </div>
                <div>
                    <label for="userRePassword">确认密码:</label>
                    <input type="text" name="userRePassword" id="userRePassword"/>
                </div>
				<div>
                    <label for="userPhone">联系电话:</label>
                    <input type="text" name="userPhone" id="userPhone"/>
                </div>
				<div>
                    <label >用户类别：</label>
                    <input type="radio" name="userIdentity" value="管理员"/>管理员
                    <input type="radio" name="userIdentity" value="学生"/>学生
                </div>
				<div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.jsp">返回</a>-->
                    <input type="hidden" value="userAdd" name="action"/>
                    <input type="submit" value="保存" onclick="history.back(-1)"/>
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
			</form>
		</div>
	</div>
    </section>
    <footer class="footer">
	</footer>
</body>
</html>