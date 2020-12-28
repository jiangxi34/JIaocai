
<%@ page import="java.util.List" %>
<%@ page import="dao.JiaoCai" %>
<%@ page import="dao.JiaoCaiImpl" %>
<%@ page import="model.Yhmodel" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>确认信息</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/wangye2.css">
</head>
<script>
	function deleteContact() {
		var result = confirm("结账成功，请注意余额变化，及发货信息");
		if (result) {

		}
	}</script>
<body>
<%
	int admin  = (int) session.getAttribute("id");
	JiaoCai dao = new JiaoCaiImpl();
	Yhmodel contact = dao.getYh(admin);
	int i = Integer.parseInt(request.getParameter("i"));
	int dd = Integer.parseInt(request.getParameter("dd"));
%>

<table align="center">
	<td height="98"><div align="center">
		<jsp:include page="topOne.jsp"/></div></td>
	</tr>
	<tr>
		<td height="43" align="center" valign="middle" background="image/daohang.jpg"><jsp:include page="topTwo.jsp"/></td>
	</tr>
</table>
	<div class="account">
		<div class="container">
			<div class="register">
					<div class="register-top-grid">
						<h3>确认个人信息</h3>
						<!-- 收货信息 start -->
						  <form action="DingDanServlet?admin=<%=admin%>&dd=<%=dd%>" method="post">
							<h4>收货信息</h4>
							<div class="input">
								<span>收货人<label></label></span>
								<input type="text" name="name" value="<%=contact.getName()%>" readonly="ture">
							</div>
							<div class="input">
								<span>收货人性别</span>
								<input type="text" name="phone" value="<%=contact.getSex()%>"  readonly="ture">
							</div>
							<div class="input">
								<span>收货地址</span>
								<input type="text" name="address" value="<%=contact.getSh()%>" readonly="ture">
							</div>
							<div class="input">
								<span>收货人手机号</span>
								<input type="text" name="address" value="<%=contact.getSjh()%>" readonly="ture" >
							</div>
							  <div class="input">
								 <span>订单金额</span>
								 <input type="text" name="je" value="<%=i%>" readonly="ture" >
							   </div>
							  <div class="register-but text-center">
								  <input type="submit" value="确定信息" onclick="deleteContact()">
							  </div>
							  <div class="register-but text-center">
								  <a href="user_xiugai.jsp">修改信息</a>
							  </div>
						   </form>
					</div>
				<div class="clearfix"> </div>
			</div>
	    </div>
	</div>
	<!--//account-->
<jsp:include page="downNews.jsp"></jsp:include>
</body>
</html>