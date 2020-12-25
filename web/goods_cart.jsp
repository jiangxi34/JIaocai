
<%@ page import="java.util.List" %>
<%@ page import="dao.JiaoCai" %>
<%@ page import="dao.JiaoCaiImpl" %>
<%@ page import="model.Shumodel" %>
<%@ page import="model.GouwuModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
	<title>购物车</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/wangye2.css">
</head>
<body>

<table align="center">
	<td height="98"><div align="center">
		<jsp:include page="topOne.jsp"/></div></td>
	</tr>

	<tr>
		<td height="43" align="center" valign="middle" background="image/daohang.jpg"><jsp:include page="topTwo.jsp"/></td>
	</tr>
</table>

<%
	int admin = (int) session.getAttribute("id");
	JiaoCai dao = new JiaoCaiImpl();
	List<GouwuModel> gouWus = dao.byGouwu(admin);
	int i=0;
%>

	<!--cart-items-->
	<div class="cart-items">
		<div class="container">
			<h2>我的订单</h2>
			   <% for (GouwuModel gouWu:gouWus)
			   {
				   i=i+gouWu.getJg()*gouWu.getSl();
			   %>
			<div class="cart-header col-md-6">
				<div class="cart-sec simpleCart_shelfItem">
					<div class="cart-item cyc">
						<a href="goods_detail.jsp?id=<%=gouWu.getId()%>">
							<img src="<%=gouWu.getTp()%>" class="img-responsive">
						</a>
					</div>
					<div class="cart-item-info">
						<h3><span>书名:<%=gouWu.getJ_name()%> </span></h3>
						<h3><span>单价: ¥ <%=gouWu.getJg()%></span></h3>
						<h3><span>数量:</span>
							<form action="ShuliangServelt?id=<%=gouWu.getG_id()%>" method="post">
							<input name="shuliang" value="<%=gouWu.getSl()%>">
							<button><input type="submit" class="aaa" value="确定数量">
							</button>
						</form>
						</h3>
					</div>
					<div class="clearfix"><a href="S_goodsServlet?id=<%=gouWu.getId()%>">删除商品</a></div>
				</div>
			</div>
			   <%}%>

			<div class="cart-header col-md-12">
				<hr>
				<h3>订单总金额: ¥<%=i%> </h3>
				<a class="btn btn-success btn-lg" style="margin-left:74%" href="user_center.jsp?je=<%=i%>">去结账</a>
			</div>

		</div>
	</div>
	<!--//cart-items-->
<jsp:include page="downNews.jsp"></jsp:include>


</body>
</html>