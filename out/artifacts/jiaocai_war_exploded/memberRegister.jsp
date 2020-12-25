

<%@ page contentType="text/html; charset=gb2312" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>会员注册</title>
</head>
 <link href="css/css1.css" rel="stylesheet" type="text/css">
<body>
<p>&nbsp;</p>
<div align="center">
  <p><strong>注册</strong></p>

  <form  method="post" action="../memberAction.do?action=0">
    <table width="298"  border="1" cellspacing="0" cellpadding="0" bordercolor="#FFFFFF" bordercolordark="#819BBC" bordercolorlight="#FFFFFF">
      <tr>
        <td width="105" height="35" bgcolor="#EFF6FE">
        <div align="center">账号</div></td>
        <td width="187"><div align="center">
          <input type="text" name="name">
        </div></td>
      </tr>
      <tr>
        <td height="35" bgcolor="#EFF6FE">
        <div align="center">密码</div></td>
        <td><div align="center">
          <input type="password" name="password">
        </div></td>
      </tr>


      <tr>
        <td height="35" bgcolor="#EFF6FE">
        <div align="center">性别</div></td>
        <td><div align="center">
         男 <INPUT type=radio value=1 name=sex checked> 女 <INPUT type=radio value=2 name=sex>
        </div>
        </td>
      </tr>




      <tr>
        <td height="35" bgcolor="#EFF6FE">
        <div align="center">电话</div></td>
        <td><div align="center">
          <input name="email" type="text" >
        </div></td>
      </tr>


      <tr>
        <td height="35" bgcolor="#EFF6FE">
          <div align="center">地址</div></td>
        <td><div align="center">
          <input type="text" name="age">
        </div></td>
      </tr>
    </table>


    <br><br><br>
    <input type="submit"  value="提交">&nbsp;&nbsp;
    <input type="reset" value="重置">
    <a href="index.jsp" type="button">返回</a>
  </form>
  <p>
  </p>
</div>
</body>
</html>
