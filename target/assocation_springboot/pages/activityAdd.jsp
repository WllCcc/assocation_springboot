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
					<li id="active"><a href="${pageContext.request.contextPath}/activity/findAll">社团活动管理</a></li>
					<li><a href="${pageContext.request.contextPath}/finance/findAll">社团财务管理</a></li>
				</ul>
			</nav>
		</div>
		<div class="right">
		    <div class="location">
				<span>位置：社团活动管理页面 >> 社团活动添加页面</span>
			</div>
			<div class="providerAdd">
			    <form action="${pageContext.request.contextPath}/activityApproval/applyAssoAct" method="post">
				    <div>
					    <label for="activityAssoId">所属社团编号:</label>
						<input type="text" name="activityAssoId" id="activityAssoId"/>
					</div>
					<div>
					    <label for="activityName">活动名称:</label>
						<input type="text" name="activityName" id="activityName"/>
					</div>
					<div>
					    <label for="activityTheme">活动主题:</label>
						<input type="text" name="activityTheme" id="activityTheme"/>
					</div>
					<div>
					    <label for="activityContent">活动内容:</label>
						<input type="text" name="activityContent" id="activityContent"/>
					</div>
					<div>
					    <label for="activityLocation">活动地点:</label>
						<input type="text" name="activityLocation" id="activityLocation"/>
					</div>
					<div>
					    <label for="activityNumber">活动人数:</label>
						<input type="text" name="activityNumber" id="activityNumber"/>
					</div>
					<div>
					    <label for="activityCost">预期经费:</label>
						<input type="text" name="activityCost" id="activityCost"/>
					</div>
					<div>
					    <label for="activityDate">活动日期:</label>
						<input type="text" name="activityDate" id="activityDate"/>
					</div>
				<div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.jsp">返回</a>-->
                    <input type="hidden" value="activityAdd" name="action"/>
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