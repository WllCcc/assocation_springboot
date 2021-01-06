<html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
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
				    <li><a href="${pageContext.request.contextPath}/user/findAll">用户管理</a></li>
					<li><a href="${pageContext.request.contextPath}/assocation/findAll">社团信息管理</a></li>
					<li><a href="${pageContext.request.contextPath}/activity/findAll">社团活动管理</a></li>
					<li id="active"><a href="${pageContext.request.contextPath}/finance/findAll">社团财务管理</a></li>
				</ul>
			</nav>
		</div>
		<div class="right">
		    <div class="location">
				<span>位置：社团财务管理页面 >> 社团财务信息查看页面</span>
			</div>
			<div class="providerView">
			    <p><span>财务编号：<%=request.getParameter("financeId")%></span></p>
				<p><span>社团名称：<%=request.getParameter("assocationName")%></span></p>
                <p><span>活动名称：<%=request.getParameter("activityName")%></span></p>
				<p><span>类别：<%=request.getParameter("category")%></span></p>
				<p><span>金额：<%=request.getParameter("financeMoney")%></span></p>
				<p><span>剩余总金额：<%=request.getParameter("financeBalance")%></span></p>
				<a href="javascript:void(0)" onclick="history.back(-1)">返回</a>
			</div>
		</div>
	</section>
    <footer class="footer">
	</footer>
</body>
</html>