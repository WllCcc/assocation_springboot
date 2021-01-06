<!DOCTYPE html>
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
				    <li id="active"><a href="${pageContext.request.contextPath}/pages/home.jsp">首页</a></li>
				    <li><a href="${pageContext.request.contextPath}/user/findAll">用户管理</a></li>
					<li><a href="${pageContext.request.contextPath}/assocation/findAll">社团信息管理</a></li>
					<li><a href="${pageContext.request.contextPath}/activity/findAll">社团活动管理</a></li>
					<li><a href="${pageContext.request.contextPath}/finance/findAll">社团财务管理</a></li>
				</ul>
			</nav>
		</div>
		<div class="right">
		    <img class="iSuccess" src="${pageContext.request.contextPath}/img/chenggong.png" alt=""/>
			<div class="iFont">
			    <h2>欢迎来到大学生社团管理系统！</h2>
				<p>点击下方图标可快捷进入特定功能</p>
				<div class="xline"></div>	
			</div>
			<ul class="iconlist">
			<li><img src="../img/xiugai1.png" width=40px height=40px/><p><a href="${pageContext.request.contextPath}/user/findAll">修改成员信息</a></p></li>
			<li><img src="../img/chaxun.png" width=40px height=40px><p><a href="${pageContext.request.contextPath}/assocation/findAll">查询社团信息</a></p></li>
			<li><img src="../img/tianjia.png" width=40px height=40px/><p><a href="${pageContext.request.contextPath}/pages/activityAdd.jsp">添加社团活动</a></p></li>
			<div class="ibox"><a class="ibtn"><img src="../img/iadd.png"/>添加新的快捷功能</a></div>
			</ul>
			<div class="xline"></div>
		</div>
	</section>
	<footer class="bottom">
	</footer>
</body>
</html>