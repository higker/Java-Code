<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
 
<html>
<head>
<title>Table1</title>
</head>
<body>
<!--
JDBC 驱动名及数据库 URL 
数据库的用户名与密码，需要根据自己的设置
 -->
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://192.168.64.2:3306/student?useUnicode=true&characterEncoding=utf-8"
     user="root"  password="root"/>
<sql:query dataSource="${snapshot}" var="result">
SELECT * from Table1;
</sql:query>
<h1>JSP 数据库</h1>
<table border="1" width="100%">
<tr>
   <th>ID</th>
   <th>姓名</th>
   <th>性别</th>
   <th>分数</th>
</tr>
<c:forEach var="row" items="${result.rows}">
<tr>
   <td><c:out value="${row.id}"/></td>
   <td><c:out value="${row.name}"/></td>
   <td><c:out value="${row.gender}"/></td>
   <td><c:out value="${row.score}"/></td>
</tr>
</c:forEach>
</table>
 
</body>
</html>