
<%@ page import="java.util.List" %>
<%@ page import="dao.JiaoCai" %>
<%@ page import="dao.JiaoCaiImpl" %>
<%@ page import="model.Shumodel" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="css/style.css">

<!DOCTYPE html>
<html>
<head>
    <title>商品详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/wangye2.css">
</head>

<script>
    function deleteContact() {
        var result = confirm("操作成功");
        if (result) {

        }
    }
</script>
<body>
<%
    int admin;
    if(session.getAttribute("id")!=null)
    {
        admin = (int) session.getAttribute("id");
    }else
    {
        admin=0;
    };
    request.setCharacterEncoding("UTF-8");
    int id=0;
    if(request.getParameter("id")!=null)
    {
        id = Integer.parseInt(request.getParameter("id"));
    }
    if (request.getAttribute("id")!=null)
      {
          id = (int) request.getAttribute("id");
      }

    JiaoCai dao = new JiaoCaiImpl();
    Shumodel contact = dao.byShu(id);
%>

<table align="center">
    <td height="98"><div align="center">
        <jsp:include page="topOne.jsp"/></div></td>
    </tr>
    <tr>
        <td height="43" align="center" valign="middle" background="image/daohang.jpg"><jsp:include page="topTwo.jsp"/></td>
    </tr>
</table>

<!--//single-page-->
<div class="single">
    <div class="container">
        <div class="single-grids">
            <div class="col-md-4 single-grid">
                <div class="flexslider">

                    <ul class="slides">
                        <li data-thumb=<%=contact.getJ_name()%>>
                            <div class="thumb-image"> <img src=<%=contact.getTp()%> data-imagezoom="true" class="img-responsive"> </div>
                        </li>
                    </ul>
                </div>
            </div>


            <div class="col-md-4 single-grid simpleCart_shelfItem">
                <h3><%=contact.getJ_name()%></h3>
                <div class="tag">
                    <p>分类 : <a href="goods.action?typeid=5"><%=contact.getLb()%></a></p>
                </div>
                <p>$<%=contact.getJs()%></p>
                <div class="galry">
                    <div class="prices">
                        <h5 class="item_price">¥<%=contact.getJg()%></h5>
                    </div>
                    <div class="clearfix"></div>
                </div>
             <%if (admin!=0){%>

                <div class="btn_form">
                    <a href="AddGouwuServelt?admin=<%=admin%>&j_id=<%=contact.getId()%>" class="add-cart item_add" onclick="deleteContact()">加入购物车</a>
                </div>
                <%if (dao.byShouchang(admin,id)==0)
                 {%>
                <div class="btn_form">
                    <a href="ShoucangServelt?admin=<%=admin%>&j_id=<%=contact.getId()%>" class="add-cart item_add" onclick="deleteContact()">收藏</a>
                </div>
                 <%}else {%>
                <div class="btn_form">
                    <a href="sShoucangServelt?admin=<%=admin%>&j_id=<%=contact.getId()%>" class="add-cart item_add" onclick="deleteContact()">取消收藏</a>
                </div>
                 <%}%>
                <%} else {%>
                <h4>登录后才能对商品进行操作哦！！！</h4>
                <div class="btn_form">
                    <a href="index.jsp" class="add-cart item_add">去登录</a>
                </div>
                <%}%>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>

<!--footer-->
<jsp:include page="/downNews.jsp"></jsp:include>
<!--//footer-->


</body>
</html>