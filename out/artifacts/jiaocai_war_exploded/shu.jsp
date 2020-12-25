<%@ page import="java.util.List" %>
<%@ page import="dao.JiaoCai" %>
<%@ page import="dao.JiaoCaiImpl" %>
<%@ page import="model.Shumodel" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <TITLE>main</TITLE>
  <META http-equiv=Content-Type content="text/html; charset=gb2312">
  <META http-equiv=pragma content=no-cache>
  <META http-equiv=cache-control content=no-cache>
  <META http-equiv=expires content=0>
  <META http-equiv=keywords content=keyword1,keyword2,keyword3>
  <META http-equiv=description content="This is my page">
  <!DOCTYPE html>
  <html>
  <head lang="en">
    <script language="JavaScript">
    </script>
    <meta charset="UTF-8">
    <title>书城</title>
    <link rel="stylesheet" type="text/css" href="css/wangye2.css">
  </head>

  <body>
  <!--header-->
<table  align="center">
    <td height="98"><div align="center">
      <jsp:include page="topOne.jsp"/></div></td>
  </tr>

  <tr>
    <td height="43" align="center" valign="middle" background="image/daohang.jpg"><jsp:include page="topTwo.jsp"/></td>
  </tr>
</table>


    <%
      String name3 = null;
      JiaoCai dao = new JiaoCaiImpl();
      if (request.getParameter("name")!=null)
      {
        name3=new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8");
      }
      if (request.getParameter("name1")!=null)
      {
        name3=request.getParameter("name1");
      }
      if (name3!=null)
      {
        List<Shumodel> shumodels = dao.getShu();
        for (Shumodel shumodel : shumodels) {%>
     <div class="zhuti">
     <div class="shangping">
      <a href="#"><img src=<%=shumodel.getTp()%>></a>
      <div class="zhushi">
        <ul>
          <li style="color: red">$<%=shumodel.getJg()%> &nbsp&nbsp &nbsp&nbsp 类型：<%=shumodel.getLb()%></li>
          <li>《<%=shumodel.getJ_name()%>》</li>
          <li><p><%=shumodel.getJs()%></p></li>
          <a href="goods_detail.jsp?id=<%=shumodel.getId()%>"><li class="lianjie">查看详情</li></a>
          <li class="goumai"><%%>人已收藏</li>
          </ul>
         </div>
         </div>
        <%
        }
      }else
      {
       List<Shumodel> shumodels = dao.getShu();
        for (Shumodel shumodel : shumodels) {%>
       <div class="zhuti">
         <div class="shangping">
           <a href="#"><img src=<%=shumodel.getTp()%>></a>
           <div class="zhushi">
             <ul>
               <li style="color: red">$<%=shumodel.getJg()%> &nbsp&nbsp &nbsp&nbsp 类型：<%=shumodel.getLb()%></li>
               <li>《<%=shumodel.getJ_name()%>》</li>
               <li><p><%=shumodel.getJs()%></p></li>
               <a href="goods_detail.jsp?id=<%=shumodel.getId()%>"><li class="lianjie">查看详情</li></a>
               <li class="goumai"><%%>人已收藏</li>
             </ul>
           </div>
         </div>
      <%}
      }%>


      <jsp:include page="downNews.jsp"></jsp:include>
  </body>
  </html>