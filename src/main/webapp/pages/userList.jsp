<%@ page import="com.assocation.domain.User" %>
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
	List<User> list = (List<User>) request.getAttribute("userList");
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
                document.getElementById("yes").href="${pageContext.request.contextPath}/user/deleteUserById?userId=" + id;
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
				    <li id="active"><a href="${pageContext.request.contextPath}/user/findAll">用户管理</a></li>
					<li><a href="${pageContext.request.contextPath}/assocation/findAll">社团信息管理</a></li>
					<li><a href="${pageContext.request.contextPath}/activity/findAll">社团活动管理</a></li>
					<li><a href="${pageContext.request.contextPath}/finance/findAll">社团财务管理</a></li>
				</ul>
			</nav>
		</div>
		<div class="right">
		    <div class="location">
				<span>位置：用户管理页面</span>
			</div>
			<div class="search">
			    <form action="${pageContext.request.contextPath}/user/findByNameAndIdentity" method="post">
				    用户名称：
					<input type="text" placeholder="请输入用户名" id="userName" name="userName"/>					
					用户类别：
					<select name="userIdentity">
						<option value="">--请选择--</option>
						<option value="管理员">管理员</option>
						<option value="学生">学生</option>
					</select>
					<input type="submit" value="查询"/>
					<a href="${pageContext.request.contextPath}/pages/userAdd.jsp">添加用户</a>
				</form>
			</div>
			<table class="providerTable" cellpadding="0" cellspacing="0">
			    <tr class="firstTr">
				    <th width="10%">用户编号</th>
				    <th width="10%">用户名称</th>
					<th width="10%">性别</th>
					<th width="10%">年级</th>
					<th width="10%">专业</th>
					<th width="15%">学院</th>
					<th width="10%">所属社团</th>
					<th width="15%">联系电话</th>
					<th width="10%">用户类别</th>
				</tr>
				<%
                    if(list != null)
                    for(User u:list){
                        %>
			    <tr class="con">
				    <td><%=u.getUserId()%></td>
					<td><%=u.getUserName()%></td>
					<td><%=u.getUserSex()%></td>
					<td><%=u.getUserGrade()%></td>
					<td><%=u.getUserClass()%></td>
					<td><%=u.getUserCollege()%></td>
					<td><%=u.getUserAssocation()%></td>
					<td><%=u.getUserPhone()%></td>
					<td><%=u.getUserIdentity()%></td>
					<td>
					    <a href="${pageContext.request.contextPath}/pages/userView.jsp?userID=<%=u.getUserId()%>&userName=<%=u.getUserName()%>&userSex=<%=u.getUserSex()%>
                            &userGrade=<%=u.getUserGrade()%>&userClass=<%=u.getUserClass()%>&userCollege=<%=u.getUserCollege()%>&userAssocation=<%=u.getUserAssocation()%>
							&userPhone=<%=u.getUserPhone()%>&userIdentity=<%=u.getUserIdentity()%>" ><img src="${pageContext.request.contextPath}/img/read.png" alt="查看" title="查看" /></a>
						<a href="${pageContext.request.contextPath}/pages/userUpdate.jsp?userID=<%=u.getUserId()%>&userName=<%=u.getUserName()%>&userSex=<%=u.getUserSex()%>
                            &userGrade=<%=u.getUserGrade()%>&userClass=<%=u.getUserClass()%>&userCollege=<%=u.getUserCollege()%>&userAssocation=<%=u.getUserAssocation()%>
							&userPhone=<%=u.getUserPhone()%>&userIdentity=<%=u.getUserIdentity()%>"><img src="${pageContext.request.contextPath}/img/xiugai.png" alt="修改" title="修改"/></a>	
						<a href="${pageContext.request.contextPath}/user/deleteUserById?userId=<%=u.getUserId()%>"><img src="${pageContext.request.contextPath}/img/schu.png" alt="删除" title="删除"/></a>
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
