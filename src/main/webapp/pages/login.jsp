<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head lang="en">
<%--    <meta charset="UTF-8">--%>
    <title>大学生社团管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Style.css"/>
	
	<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/cloud.js"></script>
	<script>
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
    });  
    </script>
</head>
<body style="background-color:#1c77ac; background-image:url(../img/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
    <div id="mainBody">
	  <div id="cloud1" class="cloud"></div>
	  <div id="cloud2" class="cloud"></div>
	</div>
    <div class="logintop">
    <span>欢迎登录大学生社团管理系统</span>
	</div>
	<div class="loginbody">
	    <header class="loginHeader">
		    <h1> </h1>
		</header>
		<form action="${pageContext.request.contextPath}/user/login" method="post">
	        <div class="loginbox">
		    <ul>
		    <li><input id="userName" class="loginuser" type="text" name="userName" placeholder="请输入用户名" required/></li>
		    <li><input id="userPassword" class="loginpwd" type="password" name="userPassword" placeholder="请输入密码" required/></li>
		    <li><input class="loginbtn" type="submit" value="登录"/>
		    <label></label>
		    <input class="loginbtn" type="reset" value="重置"/></li>
		    </ul>
		    </div>
		</form>
	</div>
	<div class="loginbm">大学生社团管理系统v1.0</div>
</body>
</html>
