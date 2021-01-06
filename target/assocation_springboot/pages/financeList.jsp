<%@ page import="com.assocation.domain.Finance" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 深埋
  Date: 2020/12/24
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
	<title>大学生社团管理系统</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Public.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Style.css"/>
</head>
<%
	@SuppressWarnings("unchecked")
	List<Finance> list = (List<Finance>) request.getAttribute("financeList");
%>
<body>
    <header class="publicHeader">
        <h1>大学生社团管理系统</h1>
	    <div class="publicHeaderR">
	        <p>欢迎使用大学生社团管理系统。</p>
	    	<a href="${pageContext.request.contextPath}/user/logout">退出</a>
    	</div>
		<script>
            function deletes(id) {
                document.getElementById("zhezhao").style.setProperty("display","inline");
                document.getElementById("removeUse").style.setProperty("display","inline");
                document.getElementById("yes").href="${pageContext.request.contextPath}/finance/deleteFinance?financeId=" + id;
            }
            function yes() {
                document.getElementById("zhezhao").style.setProperty("display","none");
                document.getElementById("removeUse").style.setProperty("display","none");
            }
        </script>
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
					<li id="active"><a href="#">社团财务管理</a></li>
				</ul>
			</nav>
		</div>
		<div class="right">
		    <div class="location">
				<span>位置：社团财务管理 >> 社团财务信息查看页面</span>
			</div>
			<div class="search">
			    <form action="${pageContext.request.contextPath}/finance/findFinanceByMore" method="post">
				    财务编号：
					<input type="text" placeholder="请输入财务编号" id="financeId" name="financeId"/>					
					类型（支出/收入）：
					<select name="financeCategory">
						<option value="">--请选择--</option>
						<option value="收入">收入</option>
						<option value="支出">支出</option>
					</select>
					<input type="submit" value="查询"/>
					<a href="${pageContext.request.contextPath}/pages/financeAdd.jsp">添加财务信息</a>
				</form>
			</div>
			<table class="providerTable" cellpadding="0" cellspacing="0">
			    <tr class="firstTr">
				    <th width="10%">财务编号</th>
				    <th width="10%">社团名称</th>
					<th width="10%">活动名称</th>
					<th width="10%">类别</th>
					<th width="10%">金额</th>
					<th width="10%">剩余总金额</th>
				</tr>
				<%
                    if(list != null)
                    for(Finance u:list){
                        %>
			    <tr class="con">
				    <td><%=u.getFinanceId()%></td>
					<td><%=u.getAssocationName()%></td>
					<td><%=u.getActivityName()%></td>
					<td><%=u.getCategory()%></td>
					<td><%=u.getFinanceMoney()%></td>
					<td><%=u.getFinanceBalance()%></td>
					<td>
					    <a href="${pageContext.request.contextPath}/pages/financeView.jsp?financeId=<%=u.getFinanceId()%>&assocationName=<%=u.getAssocationName()%>&activityName=<%=u.getActivityName()%>
                            &category=<%=u.getCategory()%>&financeMoney=<%=u.getFinanceMoney()%>&financeBalance=<%=u.getFinanceBalance()%>" ><img src="${pageContext.request.contextPath}/img/read.png" alt="查看" title="查看" /></a>
						<a href="${pageContext.request.contextPath}/pages/financeUpdate.jsp?financeId=<%=u.getFinanceId()%>&assocationName=<%=u.getAssocationName()%>&activityName=<%=u.getActivityName()%>
                            &category=<%=u.getCategory()%>&financeMoney=<%=u.getFinanceMoney()%>&financeBalance=<%=u.getFinanceBalance()%>"><img src="${pageContext.request.contextPath}/img/xiugai.png" alt="修改" title="修改"/></a>	
						<a href="${pageContext.request.contextPath}/finance/deleteFinance?financeId=<%=u.getFinanceId()%>><img src="${pageContext.request.contextPath}/img/schu.png" alt="删除" title="删除"/></a>
					</td>
				</tr>
				<%
                    }
                %>
			</table>
		</div>
	</section>

	<script src="${pageContext.request.contextPath}/js/jquery1.js"></script>
	<script src="${pageContext.request.contextPath}/js/js.js"></script>
</body>
</html>
