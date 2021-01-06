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
				<span>位置：社团活动信息管理 >> 社团活动审批页面</span>
			</div>
			<div class="providerView">
			    <p><span>活动编号：<%=request.getParameter("activityId")%></span></p>
				<p><span>所属社团编号：<%=request.getParameter("activityAssoId")%></span></p>
                <p><span>活动名称：<%=request.getParameter("activityName")%></span></p>
				<p><span>活动主题：<%=request.getParameter("activityTheme")%></span></p>
				<p><span>活动内容：<%=request.getParameter("activityContent")%></span></p>
				<p><span>活动地点：<%=request.getParameter("activityLocation")%></span></p>
				<p><span>活动人数：<%=request.getParameter("activityNumber")%></span></p>
				<p><span>预期经费：<%=request.getParameter("activityCost")%></span></p>
				<p><span>活动日期：<%=request.getParameter("activityDate")%></span></p>
				<p><span>申请日期：<%=request.getParameter("applicationDate")%></span></p>
				<p><span>申请人编号：<%=request.getParameter("applyId")%></span></p>
			</div>
			    <form action="${pageContext.request.contextPath}/activityApproval/approvalAssoAct" method="post">
					<input type="hidden" name="activityId" value="<%=request.getParameter("activityId")%>">
					<input type="hidden" name="activityAssoId" value="<%=request.getParameter("activityAssoId")%>">
					<input type="hidden" name="activityName" value="<%=request.getParameter("activityName")%>">
					<input type="hidden" name="activityTheme" value="<%=request.getParameter("activityTheme")%>">
					<input type="hidden" name="activityContent" value="<%=request.getParameter("activityContent")%>">
					<input type="hidden" name="activityLocation" value="<%=request.getParameter("activityLocation")%>">
					<input type="hidden" name="activityNumber" value="<%=request.getParameter("activityNumber")%>">
					<input type="hidden" name="activityCost" value="<%=request.getParameter("activityCost")%>">
					<input type="hidden" name="activityDate" value="<%=request.getParameter("activityDate")%>">
					<input type="hidden" name="applicationDate" value="<%=request.getParameter("applicationDate")%>">
					<input type="hidden" name="applyId" value="<%=request.getParameter("applyId")%>">
					<select name="status">
						<option value="">--请选择--</option>
						<option value="AGREE">同意</option>
						<option value="DISAGREE">不同意</option>
					</select>
					<div class="providerAddBtn">
					<input type="submit" value="审批" onclick="history.back(-1)"/>
					<div>
					</div>
					</div>
				</form>
		</div>
	</section>
    <footer class="footer">
	</footer>
</body>
</html>