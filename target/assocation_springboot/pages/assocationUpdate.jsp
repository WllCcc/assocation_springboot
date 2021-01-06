<%@ page import="com.assocation.domain.Assocation" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.ParseException" %>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<head lang="en">
    <meta charset="UTF-8">
	<title>大学生社团管理系统</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Public.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Style.css"/>
	<%
		String assocationId = request.getParameter("assocationId");
		String assocationName = request.getParameter("assocationName");
		String assocationSynopsis = request.getParameter("assocationSynopsis");
		String assocationChargeId = request.getParameter("assocationChargeId");
		String assocationCategory = request.getParameter("assocationCategory");
		String assocationEstabDate = request.getParameter("assocationEstabDate");
		String assocationStatus = request.getParameter("assocationStatus");
		String assocationRank = request.getParameter("assocationRank");
        Assocation u = new Assocation(assocationId,assocationName,assocationSynopsis,assocationChargeId,assocationCategory,assocationEstabDate,assocationStatus,assocationRank);
		session.setAttribute("assocationID",u.getAssocationId());
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
				    <<li><a href="${pageContext.request.contextPath}/pages/home.jsp">首页</a></li>
				    <li><a href="${pageContext.request.contextPath}/user/findAll">用户管理</a></li>
					<li id="active"><a href="${pageContext.request.contextPath}/assocation/findAll">社团信息管理</a></li>
					<li><a href="${pageContext.request.contextPath}/activity/findAll">社团活动管理</a></li>
					<li><a href="${pageContext.request.contextPath}/finance/findAll">社团财务管理</a></li>
				</ul>
			</nav>
		</div>
		<div class="right">
		    <div class="location">
				<span>位置：社团管理页面 >> 社团信息修改页面</span>
			</div>
			<div class="providerAdd">
			    <form action="${pageContext.request.contextPath}/assocation/updateAssocation" method="post">
					<input type="hidden" name="assocationId" value="<%=u.getAssocationId()%>">
					<div>
					    <label for="assocationName">社团名称:</label>
						<input type="text" name="assocationName" id="assocationName" placeholder="<%=u.getAssocationName()%>" value="<%=u.getAssocationName()%>"/>
					</div>
					<div>
					    <label for="assocationSynopsis">社团简介:</label>
						<input type="text" name="assocationSynopsis" id="assocationSynopsis" placeholder="<%=u.getAssocationSynopsis()%>" value="<%=u.getAssocationSynopsis()%>"/>
					</div>
					<div>
					    <label for="assocationChargeId">负责人学号:</label>
						<input type="text" name="assocationChargeId" id="assocationChargeId" placeholder="<%=u.getAssocationChargeId()%>" value="<%=u.getAssocationChargeId()%>"/>
					</div>
					<div>
					    <label for="assocationCategory">社团类别:</label>
						<input type="text" name="assocationCategory" id="assocationCategory" placeholder="<%=u.getAssocationCategory()%>" value="<%=u.getAssocationCategory()%>"/>
					</div>
					<div>
					    <label for="assocationEstabDate">成立时间:</label>
						<input type="text" name="assocationEstabDate" id="assocationEstabDate" placeholder="<%=u.getAssocationEstabDate()%>" value="<%=u.getAssocationEstabDate()%>"/>
					</div>
					<div>
					    <label for="assocationStatus">社团状态:</label>
						<input type="text" name="assocationStatus" id="assocationStatus" placeholder="<%=u.getAssocationStatus()%>" value="<%=u.getAssocationStatus()%>"/>
					</div>
					<div>
                        <label for="assocationRank">社团等级:</label>
						<input type="text" name="assocationRank" id="assocationRank" placeholder="<%=u.getAssocationRank()%>" value="<%=u.getAssocationRank()%>"/>
                    </div>
					<div class="providerAddBtn">
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