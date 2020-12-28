
<%@ page import="java.util.List" %>
<%@ page import="dao.JiaoCai" %>
<%@ page import="dao.JiaoCaiImpl" %>
<%@ page import="model.Yhmodel" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>个人中心</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/wangye2.css">
</head>
<body>
<%
	int admin;
	if (request.getParameter("xgyh")!=null)
	{
		admin = Integer.parseInt(request.getParameter("xgyh"));
	}
	else {
		admin  = (int) session.getAttribute("id");
	}
	JiaoCai dao = new JiaoCaiImpl();
	Yhmodel contact = dao.getYh(admin);
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
						<h3>个人中心</h3>
						<!-- 收货信息 start -->
						  <form action="XiugaiYhServelt?admin=<%=admin%>&zhye=<%=contact.getZhye()%>" method="post">
							<h4>个人信息</h4>
							<div class="input">
								<span>用户名<label></label></span>
								<input type="text" name="name" value="<%=contact.getName()%>">
							</div>
							  <div class="input">
								  <span>密码</span>
								  <input type="password" name="mm" value="<%=contact.getMm()%>"  >
							  </div>
							<div class="input">
								<span>性别</span>
								<%if (contact.getSex().equals("男")){ %>
								男 <INPUT type=radio value="男" name=sex checked> 女 <INPUT type=radio value="女" name=sex>
								<%} else { %>
									男 <INPUT type=radio value="男" name=sex > 女 <INPUT type=radio value="女" name=sex checked>
								<%}%>
							</div>
							<div class="input">
								<span>收货地址</span>
								<input type="text" name="sh" value="<%=contact.getSh()%>">
							</div>
							<div class="input">
								<span>手机号码</span>
								<input type="text" name="sjh" value="<%=contact.getSjh()%>">
							</div>

							  <div class="input">
								  <span>账户余额</span>
								  <input type="text" name="sjh" value="<%=contact.getZhye()%>"  readonly="ture">
							  </div>

							  <div class="register-but text-center">
								  <input type="submit" value="确定修改">
							  </div>

						   </form>
					</div>
			</div>
	    </div>
	</div>
	<!--//account-->
<jsp:include page="downNews.jsp"></jsp:include>
</body>
</html>