<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<%%>
<link href="css/css.css" rel="stylesheet" type="text/css">


<table width="757" height="106"  border="0" cellpadding="0" cellspacing="0"  background="image/banner.jpg">
        <tr>
          <td width="82%" height="106">&nbsp;</td>
          <td width="18%"><div align="center">&nbsp;
              <table width="61%" height="24"  border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td height="24" style="color:#FFFFFF "><ul>
				  <%
                %>
				  <li>
                    <div align="right" class="linkWhite"><a href="index.jsp">主页</a></div>
                  </li>
                      <%if(session.getAttribute("id")!=null)
                      {%>
                      <li>
                          <div align="right" class="linkWhite"><a href="goods_cart.jsp">订单</a></div>
                      </li>
                      <%}%>
                      <li>
                          <div align="right" class="linkWhite"><a href="../<%%>">分类查看</a></div>
                      </li>
				  <%%>
                  </ul></td>
                </tr>
              </table>
</div></td>
        </tr>
</table>
