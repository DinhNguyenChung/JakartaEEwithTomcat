<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.quanlythuocwithtomcat.entities.LoaiThuoc" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 24/10/2024
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Quản ly loai thuoc</h1>
<%
    List<LoaiThuoc> dsloaithuoc = new ArrayList<>();
    dsloaithuoc = (List<LoaiThuoc>) session.getAttribute("dsloaithuoc");
    for (LoaiThuoc lt:dsloaithuoc){

%>
<p>
    <%=lt.toString()%>
</p>
<%
    }
%>
<a href="QuanLyThuocServlet?action=quanlythuoc">Quan Ly Thuoc</a> |
<a href="themthuocmoi.jsp">Them Thuoc Moi</a> |
<a href="index.jsp">Trang chính</a>
</body>
</html>
