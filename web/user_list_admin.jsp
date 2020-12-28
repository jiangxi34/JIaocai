<%@ page import="dao.JiaoCai" %>
<%@ page import="dao.JiaoCaiImpl" %>
<%@ page import="javax.swing.*" %>
<%@ page import="model.Yhmodel" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<title>客户列表</title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="css/bootstrap.css"/> 
</head>
<body>
<div class="container-fluid">

	<jsp:include page="header_admin.jsp"></jsp:include>

	<div class="text-right"><a class="btn btn-warning" href="memberRegister.jsp">添加客户</a></div>
	<br>
	<br>
	<table class="table table-bordered table-hover">
	<tr>
		<th width="5%">ID</th>
		<th width="10%">用户名</th>
		<th width="10%">性别</th>
		<th width="10%">电话</th>
		<th width="10%">地址</th>
		<th width="10%">账户余额</th>
		<th width="12%">操作</th>
	</tr>
		<%
			JiaoCai dao = new JiaoCaiImpl();
			List<Yhmodel> yhmodelList= dao.getallYh();
		for (Yhmodel yhmodel:yhmodelList)
		{%>
		<tr>
			<td><p><%=yhmodel.getId()%></p></td>
			<td><p><%=yhmodel.getName()%></p></td>
			<td><p><%=yhmodel.getSex()%></p></td>
			<td><p><%=yhmodel.getSjh()%></p></td>
			<td><p><%=yhmodel.getSh()%></p></td>
			<td><p><%=yhmodel.getZhye()%></p></td>
			<td>
				<a class="btn btn-info" href="UserServelt?admin=<%=yhmodel.getId()%>&j_id=1">重置密码</a>
				<a class="btn btn-primary" href="user_xiugai.jsp?xgyh=<%=yhmodel.getId()%>">修改</a>
				<a class="btn btn-danger" href="UserServelt?admin=<%=yhmodel.getId()%>&j_id=2">删除</a>
			</td>
		</tr>
		<%}%>
</table>

<br>
	<jsp:include page="downNews.jsp">
		<jsp:param value="/admin/user_list" name="url"/>
	</jsp:include>
<br>
</div>
</body>
</html>