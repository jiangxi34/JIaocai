<%@ page import="model.Ddmodel" %>
<%@ page import="dao.JiaoCai" %>
<%@ page import="dao.JiaoCaiImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Shumodel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <title>订单列表</title>
    <link rel="stylesheet" href="css/bootstrap.css"/>
</head>
<body>
<div class="container-fluid">

    <jsp:include page="header_admin.jsp"></jsp:include>
    <%
        int admin = (int) session.getAttribute("id");
        JiaoCai dao = new JiaoCaiImpl();
        List<Ddmodel> ddmodels = dao.ChakanDdadmin();
    %>
    <table class="table table-bordered table-hover">
        <tr>
            <th width="10%">ID</th>
            <th width="10%">总价</th>
            <th width="20%">商品详情</th>
            <th width="10%">订单状态</th>
            <th width="10%">下单时间</th>
            <th width="10%">操作</th>
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
                    <a href="ShouhuoServelt?d_id=<%=ddmodel.getD_id()%>&y_id<%=admin%>" onclick="shou()"><span style="color:red;">已发货(点击确认收货)</span></a>
                    <%}else{%>
                    <span style="color:red;">已收货</span>
                    <%}%>
                </p>
            </td>
            <td><p><%=ddmodel.getDate()%></p></td>
            <td><p><a href="ShouhuoServelt?y_id=<%=ddmodel.getY_id()%>&d_id=<%=ddmodel.getD_id()%>&fa='发'">发货</a><br></p></td>
        </tr>
        <%}%>
    </table>

    <br>
    <jsp:include page="downNews.jsp"></jsp:include>
    <br>


</div>
</body>
</html>