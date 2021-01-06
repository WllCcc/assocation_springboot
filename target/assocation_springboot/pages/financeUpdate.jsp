<%@ page import="com.assocation.domain.Finance" %>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<head lang="en">
    <meta charset="UTF-8">
	<title>大学生社团管理系统</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Public.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Style.css"/>
	<%
		String financeId = request.getParameter("financeId");
		String assocationName = request.getParameter("assocationName");
		String activityName = request.getParameter("activityName");
		String category = request.getParameter("category");
		String financeMoney = request.getParameter("financeMoney");
		String financeBalance = request.getParameter("financeBalance");
        Finance u = new Finance(financeId,assocationName,activityName,category,financeMoney,financeBalance);
		session.setAttribute("financeId",u.getFinanceId());
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
				    <li><a href="${pageContext.request.contextPath}/user/findAll">用户管理</a></li>
					<li><a href="${pageContext.request.contextPath}/assocation/findAll">社团信息管理</a></li>
					<li><a href="${pageContext.request.contextPath}/activity/findAll">社团活动管理</a></li>
					<li id="active"><a href="${pageContext.request.contextPath}/finance/findAll">社团财务管理</a></li>
				</ul>
			</nav>
		</div>
		<div class="right">
		    <div class="location">
				<span>位置：社团财务管理页面 >> 社团财务信息修改页面</span>
			</div>
			<div class="providerAdd">
			    <form action="${pageContext.request.contextPath}/finance/updateFinance" method="post">
					<input type="hidden" name="financeId" value="<%=u.getFinanceId()%>">
				    <div>
					    <label for="assocationName">社团名称:</label>
						<input type="text" name="assocationName" id="assocationName" placeholder="<%=u.getAssocationName()%>" value="<%=u.getAssocationName()%>"/>
					</div>
					<div>
					    <label for="activityName">活动名称:</label>
						<input type="text" name="activityName" id="activityName" placeholder="<%=u.getActivityName()%>" value="<%=u.getActivityName()%>"/>
					</div>
					<div>
					    <label for="category">类别:</label>
						<input type="text" name="category" id="category" placeholder="<%=u.getCategory()%>" value="<%=u.getCategory()%>"/>
					</div>
					<div>
					    <label for="financeMoney">金额:</label>
						<input type="text" name="financeMoney" id="financeMoney" placeholder="<%=u.getFinanceMoney()%>" value="<%=u.getFinanceMoney()%>"/>
					</div>
					<div>
					    <label for="financeBalance">剩余总金额:</label>
						<input type="text" name="financeBalance" id="financeBalance" placeholder="<%=u.getFinanceBalance()%>" value="<%=u.getFinanceBalance()%>"/>
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