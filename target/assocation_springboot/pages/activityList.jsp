<%@ page import="com.assocation.domain.Activity" %>
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
	List<Activity> list = (List<Activity>) request.getAttribute("activityList");
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
                document.getElementById("yes").href="${pageContext.request.contextPath}/assocation/deleteAssocation?assoId=" + id;
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
					<li id="active"><a href="${pageContext.request.contextPath}/activity/findAll">社团活动管理</a></li>
					<li><a href="${pageContext.request.contextPath}/finance/findAll">社团财务管理</a></li>
				</ul>
			</nav>
		</div>
		<div class="right">
		    <div class="location">
				<span>位置：社团活动信息管理 >> 社团活动信息查看页面</span>
			</div>
			<div class="search">
			    <form action="${pageContext.request.contextPath}/activity/findActivityById" method="post">
				    活动编号：
					<input type="text" placeholder="请输入活动编号" id="activityId" name="activityId"/>	
                    <input type="submit" value="按活动编号查询"/>	
                </form>
                <form action="${pageContext.request.contextPath}/activity/findByNameAndAssoId" method="post">		
					活动名称：
					<input type="text" placeholder="请输入活动名称" id="activityName" name="activityName"/>
					社团编号：
					<input type="text" placeholder="请输入社团编号" id="assoId" name="assoId"/>
				    <input type="submit" value="按活动名和社团编号查询"/>
				</form>
					<div>
					<a href="${pageContext.request.contextPath}/pages/activityAdd.jsp">创建社团活动</a>
					<a href="${pageContext.request.contextPath}/activityApproval/findAll">审批社团活动</a>
                    </div>					
			</div>
			<table class="providerTable" cellpadding="0" cellspacing="0">
			    <tr class="firstTr">
				    <th width="10%">活动编号</th>
				    <th width="10%">社团编号</th>
					<th width="10%">活动名称</th>
					<th width="10%">活动主题</th>
					<th width="10%">活动内容</th>
					<th width="10%">活动人数</th>
					<th width="10%">活动日期</th>
					<th width="10%">活动地点</th>
					<th width="10%">预期经费</th>
				</tr>
				<%
                    if(list != null)
                    for(Activity u:list){
                        %>
			    <tr class="con">
				    <td><%=u.getActivityId()%></td>
					<td><%=u.getAssocationId()%></td>
					<td><%=u.getActivityName()%></td>
					<td><%=u.getActivityTheme()%></td>
					<td><%=u.getActivityContent()%></td>
					<td><%=u.getActivityNumber()%></td>
					<td><%=u.getActivityDate()%></td>
					<td><%=u.getActivityLocation()%></td>
					<td><%=u.getActivityCost()%></td>
					<td>
					    <a href="${pageContext.request.contextPath}/pages/activityView.jsp?activityId=<%=u.getActivityId()%>&assocationId=<%=u.getAssocationId()%>&activityName=<%=u.getActivityName()%>
                            &activityTheme=<%=u.getActivityTheme()%>&activityContent=<%=u.getActivityContent()%>&activityNumber=<%=u.getActivityNumber()%>&activityDate=<%=u.getActivityDate()%>
							&activityLocation=<%=u.getActivityLocation()%>&activityCost=<%=u.getActivityCost()%>" ><img src="${pageContext.request.contextPath}/img/read.png" alt="查看" title="查看" /></a>
						<a href="${pageContext.request.contextPath}/pages/activityUpdate.jsp?activityId=<%=u.getActivityId()%>&assocationId=<%=u.getAssocationId()%>&activityName=<%=u.getActivityName()%>
                            &activityTheme=<%=u.getActivityTheme()%>&activityContent=<%=u.getActivityContent()%>&activityNumber=<%=u.getActivityNumber()%>&activityDate=<%=u.getActivityDate()%>
							&activityLocation=<%=u.getActivityLocation()%>&activityCost=<%=u.getActivityCost()%>"><img src="${pageContext.request.contextPath}/img/xiugai.png" alt="修改" title="修改"/></a>	
						<a href="${pageContext.request.contextPath}/activity/deleteActivity?activityId=<%=u.getActivityId()%>"><img src="${pageContext.request.contextPath}/img/schu.png" alt="删除" title="删除"/></a>
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
