<%@ page import="dao.JiaoCai" %>
<%@ page import="dao.JiaoCaiImpl" %>
<%@ page import="model.Ddmodel" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Shumodel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
	<title>我的订单</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<script>
	function shou() {
		var result = confirm("确定以收货");
		if (result) {
		}
	}</script>
<body>
<%
	int admin = (int) session.getAttribute("id");
	JiaoCai dao = new JiaoCaiImpl();
	List<Ddmodel> ddmodels = dao.ChakanDd(admin);
%>

<table align="center">
	<td height="98"><div align="center">
		<jsp:include page="topOne.jsp"/></div></td>
	</tr>

	<tr>
		<td height="43" align="center" valign="middle" background="image/daohang.jpg"><jsp:include page="topTwo.jsp"/></td>
	</tr>
</table>

	<!--cart-items-->
	<div class="cart-items">
		<div class="container">

			<h2>我的订单</h2>
			
				<table class="table table-bordered table-hover">
				<tr>
					<th width="10%">ID</th>
					<th width="10%">总价</th>
					<th width="20%">商品详情</th>
					<th width="10%">订单状态</th>
					<th width="10%">下单时间</th>
				</tr>
					<%for (Ddmodel ddmodel:ddmodels ){%>
					<tr>
						<td><p><%=ddmodel.getD_id()%></p></td>
						<td><p><%=ddmodel.getZje()%></p></td>
						<td>
							<%
								List<Shumodel> shumodels = dao.Chakangwc(admin,ddmodel.getD_id());
								for (Shumodel shumodel:shumodels){%>
									<p><%=shumodel.getJ_name()%>(<%=shumodel.getJg()%>) x <%=shumodel.getId()%></p>
								<%}%>
						</td>
						<td>
							<p>
								<%
								if (ddmodel.getZt()==1)
								{%>
								<span style="color:red;">已付款</span>
								<%}else if (ddmodel.getZt()==2){%>
								<a href="ShouhuoServelt?d_id=<%=ddmodel.getD_id()%>&y_id=<%=admin%>" onclick="shou()"><span style="color:red;">已发货(点击确认收货)</span></a>
								<%}else{%><span style="color:red;">已收货</span><%}%>
							</p>
						</td>
						<td><p><%=ddmodel.getDate()%></p></td>
					</tr>
					<%}%>
				</table>

		</div>
	</div>
	<!--//cart-items-->

<jsp:include page="downNews.jsp"></jsp:include>

</body>
</html>