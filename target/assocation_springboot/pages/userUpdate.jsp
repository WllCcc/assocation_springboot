<%@ page import="com.assocation.domain.User" %>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<head lang="en">
    <meta charset="UTF-8">
	<title>大学生社团管理系统</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Public.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Style.css"/>
	<%
		String userId = request.getParameter("userID");
		String userName = request.getParameter("userName");
		String userSex = request.getParameter("userSex");
		String userGrade = request.getParameter("userGrade");
		String userClass = request.getParameter("userClass");
		String userCollege = request.getParameter("userCollege");
		String userAssocation = request.getParameter("userAssocation");
		String userPhone = request.getParameter("userPhone");
		String userIdentity = request.getParameter("userIdentity");
        User u= new User(userId,userName,userSex,userGrade,userClass,userCollege,userAssocation,"","",userPhone,userIdentity);
		session.setAttribute("userID",u.getUserId());
	%>
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
				<span>位置：用户管理页面 >> 用户信息修改页面</span>
			</div>
			<div class="providerAdd">
			    <form action="${pageContext.request.contextPath}/user/updateUser" method="post">
					<input type="hidden" name="userId" value="<%=u.getUserId()%>">
					<div>
					    <label for="userName">用户名称:</label>
						<input type="text" name="userName" id="userName" placeholder="<%=u.getUserName()%>" value="<%=u.getUserName()%>"/>
					</div>
					<div>
						<label for="userSex">用户性别:</label>
						<input type="text" name="userSex" id="userSex" placeholder="<%=u.getUserSex().trim()%>" value="<%=u.getUserSex().trim()%>"/>
					</div>
					<div>
					    <label for="userGrade">用户年级:</label>
						<input type="text" name="userGrade" id="userGrade" placeholder="<%=u.getUserGrade()%>" value="<%=u.getUserGrade()%>"/>
					</div>
					<div>
					    <label for="userClass">用户专业:</label>
						<input type="text" name="userClass" id="userClass" placeholder="<%=u.getUserClass()%>" value="<%=u.getUserClass()%>"/>
					</div>
					<div>
					    <label for="userCollege">用户学院:</label>
						<input type="text" name="userCollege" id="userCollege" placeholder="<%=u.getUserCollege()%>" value="<%=u.getUserCollege()%>"/>
					</div>
					<div>
					    <label for="userAssocation">所属社团:</label>
						<input type="text" name="userAssocation" id="userAssocation" placeholder="<%=u.getUserAssocation()%>" value="<%=u.getUserAssocation()%>"/>
					</div>
					<div>
					    <label for="userPhone">联系电话:</label>
						<input type="text" name="userPhone" id="userPhone" placeholder="<%=u.getUserPhone()%>" value="<%=u.getUserPhone()%>"/>
					</div>
					<div>
						<label for="userIdentity">用户类别:</label>
						<input type="text" name="userIdentity" id="userIdentity" placeholder="<%=u.getUserIdentity()%>" value="<%=u.getUserIdentity()%>"/>
					</div>
					<div class="userAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.jsp">返回</a>-->
                    <input type="hidden" name="action" value="TrueUpdate"/>
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