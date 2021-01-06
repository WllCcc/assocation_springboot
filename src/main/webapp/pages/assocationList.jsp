<%@ page import="com.assocation.domain.Assocation" %>
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
	List<Assocation> list = (List<Assocation>) request.getAttribute("assocationList");
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
					<li id="active"><a href="${pageContext.request.contextPath}/assocation/findAll">社团信息管理</a></li>
					<li><a href="${pageContext.request.contextPath}/activity/findAll">社团活动管理</a></li>
					<li><a href="${pageContext.request.contextPath}/finance/findAll">社团财务管理</a></li>
				</ul>
			</nav>
		</div>
		<div class="right">
		    <div class="location">
				<span>位置：社团信息管理 >> 社团信息查看页面</span>
			</div>
			<div class="search">
			    <form action="${pageContext.request.contextPath}/assocation/findAssoByMultiCons" method="post">
				    社团名称：
					<input type="text" placeholder="请输入社团名称" id="assoName" name="assoName"/>					
					社团状态：
					<select name="assoStatus">
						<option value="">--请选择--</option>
						<option value="正常">正常</option>
						<option value="停止">停止</option>
					</select>
					社团等级：
					<select name="assoRank">
						<option value="">--请选择--</option>
						<option value="优秀">优秀</option>
						<option value="良好">良好</option>
						<option value="及格">及格</option>
						<option value="不及格">不及格</option>
					</select>
					<input type="submit" value="查询"/>
					<div>
					<a href="${pageContext.request.contextPath}/pages/assocationAdd.jsp">创建社团</a>
					<a href="${pageContext.request.contextPath}/estApproval/findAll">审批社团</a>
                    </div>					
				</form>
			</div>
			<table class="providerTable" cellpadding="0" cellspacing="0">
			    <tr class="firstTr">
				    <th width="10%">社团编号</th>
				    <th width="10%">社团名称</th>
					<th width="10%">社团简介</th>
					<th width="10%">负责人学号</th>
					<th width="10%">社团类别</th>
					<th width="10%">成立时间</th>
					<th width="10%">社团状态</th>
					<th width="10%">社团等级</th>
				</tr>
				<%
                    if(list != null)
                    for(Assocation u:list){
                        %>
			    <tr class="con">
				    <td><%=u.getAssocationId()%></td>
					<td><%=u.getAssocationName()%></td>
					<td><%=u.getAssocationSynopsis()%></td>
					<td><%=u.getAssocationChargeId()%></td>
					<td><%=u.getAssocationCategory()%></td>
					<td><%=u.getAssocationEstabDate()%></td>
					<td><%=u.getAssocationStatus()%></td>
					<td><%=u.getAssocationRank()%></td>
					<td>
					    <a href="${pageContext.request.contextPath}/pages/assocationView.jsp?assocationId=<%=u.getAssocationId()%>&assocationName=<%=u.getAssocationName()%>&assocationSynopsis=<%=u.getAssocationSynopsis()%>
                            &assocationChargeId=<%=u.getAssocationChargeId()%>&assocationCategory=<%=u.getAssocationCategory()%>&assocationEstabDate=<%=u.getAssocationEstabDate()%>&assocationStatus=<%=u.getAssocationStatus()%>
							&assocationRank=<%=u.getAssocationRank()%>" ><img src="${pageContext.request.contextPath}/img/read.png" alt="查看" title="查看" /></a>
						<a href="${pageContext.request.contextPath}/pages/assocationUpdate.jsp?assocationId=<%=u.getAssocationId()%>&assocationName=<%=u.getAssocationName()%>&assocationSynopsis=<%=u.getAssocationSynopsis()%>
                            &assocationChargeId=<%=u.getAssocationChargeId()%>&assocationCategory=<%=u.getAssocationCategory()%>&assocationEstabDate=<%=u.getAssocationEstabDate()%>&assocationStatus=<%=u.getAssocationStatus()%>
							&assocationRank=<%=u.getAssocationRank()%>"><img src="${pageContext.request.contextPath}/img/xiugai.png" alt="修改" title="修改"/></a>	
						<a href="${pageContext.request.contextPath}/assocation/deleteAssocation?assocationId=<%=u.getAssocationId()%>"><img src="${pageContext.request.contextPath}/img/schu.png" alt="删除" title="删除"/></a>
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
