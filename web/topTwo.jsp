<%@ page contentType="text/html; charset=gb2312" %>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/css.css" rel="stylesheet" type="text/css">

<%if(session.getAttribute("id")==null){%>
<table width="97%" height="41"  border="0" align="center" cellpadding="0" cellspacing="0" >
    <tr align="center" >
        <td width="117" height="39" class="linkWhite"><a href="index.jsp" >首页<br>
        </a></td>
        <td width="117" height="39" class="linkWhite"><a href="index.jsp" >购书首页<br>
        </a></td>
        <td width="117" class="linkWhite"><a href="shu.jsp?name1=消费行为分析">消费行为分析<br>
        </a></td>
        <td width="117" class="linkWhite"><a href="shu.jsp?name1=英语启蒙">英语启蒙<br>
        </a></td>
        <td width="117" class="linkWhite"><a href="shu.jsp?name1=语文" >语文<br>
        </a></td>
        <td width="117" class="linkWhite"><a href="shu.jsp?name1=数学" >数学<br>
        </a></td>
        <td width="117" class="linkWhite"><a href="shu.jsp?name1=计算机技术" >计算机技术<br>
        </a></td>
        <td width="117" class="linkWhite"><a href="shu.jsp?name1=心理学" >心理学<br>
        </a></td>
        <td width="117" class="linkWhite"><a href="shu.jsp?name1=创新思维" >创新思维<br>
        </a></td>
    </tr>
</table>
<%}else{%>
<table width="97%" height="41"  border="0" align="center" cellpadding="0" cellspacing="0" >
    <tr align="center" >
        <td width="117" height="39" class="linkWhite"><a href="index.jsp" >首页<br>
        </a></td>
        <td width="117" height="39" class="linkWhite"><a href="index.jsp" >购书首页<br>
        </a></td>
        <td width="117" class="linkWhite"><a href="shu.jsp?name1=消费行为分析">消费行为分析<br>
        </a></td>
        <td width="117" class="linkWhite"><a href="shu.jsp?name1=英语启蒙">英语启蒙<br>
        </a></td>
        <td width="117" class="linkWhite"><a href="shu.jsp?name1=语文" >语文<br>
        </a></td>
        <td width="117" class="linkWhite"><a href="shu.jsp?name1=数学" >数学<br>
        </a></td>
        <td width="117" class="linkWhite"><a href="shu.jsp?name1=计算机技术" >计算机技术<br>
        </a></td>
        <td width="117" class="linkWhite"><a href="shu.jsp?name1=心理学" >心理学<br>
        </a></td>
        <td width="117" class="linkWhite"><a href="shu.jsp?name1=创新思维" >创新思维<br>
        </a></td>
    </tr>
</table>
<table width="97%" height="41"  border="0" align="center" cellpadding="0" cellspacing="0">
      <tr align="center">
        <td width="117" class="linkWhite"><a href="order_list.jsp">订单查看<br>
  </a></td>
        <td width="117" class="linkWhite"><a href="goods_cart.jsp">购物车<br>
  </a></td>
          <td width="117" class="linkWhite"><a href="shu.jsp?shou=<%= (int) session.getAttribute("id")%>">我的收藏<br>
          </a></td>
        <td width="117" class="linkWhite"><a href="user_xiugai.jsp">个人信息中心<br>
  </a></td>
          <%if((int) session.getAttribute("id")==1)
          {%>
          <td width="117" class="linkWhite"><a href="order_list_admin.jsp">后台管理<br>
          </a></td>order_list.jsp
          <%}%>
          <td width="117" class="linkWhite"><a href="user_xiugai.jsp">账户充值<br>
          </a></td>
      </tr>
</table>
<%}%>
