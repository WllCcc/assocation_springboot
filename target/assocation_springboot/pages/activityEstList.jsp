<%@ page import="com.assocation.domain.ActivityApproval" %>
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
	<link rel="stylesheet" href="../css/Public.css"/>
	<link rel="stylesheet" href="../css/Style.css"/>
</head>
<%
	@SuppressWarnings("unchecked")
	List<ActivityApproval> list = (List<ActivityApproval>) request.getAttribute("activityApprovalList");
%>
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
					<li id="active"><a href="#">社团活动管理</a></li>
					<li><a href="${pageContext.request.contextPath}/finance/findAll">社团财务管理</a></li>
				</ul>
			</nav>
		</div>
		<div class="right">
		    <div class="location">
				<span>位置：社团活动信息管理 >> 社团活动审批信息查看页面</span>
			</div>
			<table class="providerTable" cellpadding="0" cellspacing="0">
			    <tr class="firstTr">
				    <th width="8%">活动编号</th>
				    <th width="8%">社团编号</th>
					<th width="8%">活动名称</th>
					<th width="8%">活动主题</th>
					<th width="8%">活动内容</th>
					<th width="8%">活动地点</th>
					<th width="8%">活动人数</th>
					<th width="8%">预期经费</th>
					<th width="8%">活动日期</th>
					<th width="8%">申请日期</th>
					<th width="8%">审批日期</th>
					<th width="8%">审批状态</th>
					<th width="8%">申请人编号</th>
					<th width="8%">审批人编号</th>
				</tr>
				<%
                    if(list != null)
                    for(ActivityApproval u:list){
                        %>
			    <tr class="con">
				    <td><%=u.getActivityId()%></td>
					<td><%=u.getActivityAssoId()%></td>
					<td><%=u.getActivityName()%></td>
					<td><%=u.getActivityTheme()%></td>
					<td><%=u.getActivityContent()%></td>
					<td><%=u.getActivityLocation()%></td>
					<td><%=u.getActivityNumber()%></td>
					<td><%=u.getActivityCost()%></td>
					<td><%=u.getActivityDate()%></td>
					<td><%=u.getApplicationDate()%></td>
					<td><%=u.getApprovalDate()%></td>
					<td><%=u.getStatus()%></td>
					<td><%=u.getApplyId()%></td>
					<td><%=u.getApprovalId()%></td>
					<td>
					    <a href="${pageContext.request.contextPath}/pages/activityEstView.jsp?activityId=<%=u.getActivityId()%>&activityAssoId=<%=u.getActivityAssoId()%>&activityName=<%=u.getActivityName()%>
                            &activityTheme=<%=u.getActivityTheme()%>&activityContent=<%=u.getActivityContent()%>&activityLocation=<%=u.getActivityLocation()%>&activityNumber=<%=u.getActivityNumber()%>
							&activityCost=<%=u.getActivityCost()%>&activityDate=<%=u.getActivityDate()%>&applicationDate=<%=u.getApplicationDate()%>&approvalDate=<%=u.getApprovalDate()%>
							&status=<%=u.getStatus()%>&applyId=<%=u.getApplyId()%>&approvalId=<%=u.getApprovalId()%>" ><img src="${pageContext.request.contextPath}/img/read.png" alt="查看" title="查看" /></a>
						<a href="${pageContext.request.contextPath}/pages/activityEst.jsp?activityId=<%=u.getActivityId()%>&activityAssoId=<%=u.getActivityAssoId()%>&activityName=<%=u.getActivityName()%>
                            &activityTheme=<%=u.getActivityTheme()%>&activityContent=<%=u.getActivityContent()%>&activityLocation=<%=u.getActivityLocation()%>&activityNumber=<%=u.getActivityNumber()%>
							&activityCost=<%=u.getActivityCost()%>&activityDate=<%=u.getActivityDate()%>&applicationDate=<%=u.getApplicationDate()%>&approvalDate=<%=u.getApprovalDate()%>
							&status=<%=u.getStatus()%>&applyId=<%=u.getApplyId()%>&approvalId=<%=u.getApprovalId()%>"><img src="${pageContext.request.contextPath}/img/xiugai.png" alt="审批" title="审批"/></a>	
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
