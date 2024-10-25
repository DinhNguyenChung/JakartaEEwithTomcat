<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.quanlythuocwithtomcat.entities.Thuoc" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="vn.edu.iuh.fit.quanlythuocwithtomcat.entities.LoaiThuoc" %><%--
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
<h1>Quan ly thuoc</h1>
<form action="QuanLyThuocServlet" method="post">
    <input type="hidden" name="action" value="timThuocTheoMaLoai">
    <label for="maLoai">Chon mã loại: </label>
    <select name="maLoai" id="maLoai">
        <option value="">--Chon ma loai--</option>
<%
    List<LoaiThuoc> dsLoai = new ArrayList<>();
    dsLoai= (List<LoaiThuoc>) session.getAttribute("dsloaithuoc");
    for (LoaiThuoc lt:dsLoai){
%>
        <option value="<%=lt.getMaLoaiThuoc()%>"><%=lt.getMaLoaiThuoc()%></option>
        <%
            }
        %>
    </select>
    <input type="submit" value="Tìm kiếm">

</form>
<form method="post" action="QuanLyThuocServlet">

    <label for="mathuoc">Nhap ma thuoc can chinh sua</label>
    <input id="mathuoc" name="mathuoc" type="text">
    <input type="hidden" name="action" value="chinhsuathuoc">
    <input type="submit" value="Chỉnh sửa">
</form>
<%
    List<Thuoc> dsthuoc = new ArrayList<>();
    dsthuoc = (List<Thuoc>) session.getAttribute("dsthuoc");
    for (Thuoc t:dsthuoc){
%>
<p>
    <%=
       t.toString()
    %>
</p>
<%
    }
%>
<a href="QuanLyThuocServlet?action=quanlyloaithuoc">Quan Ly loai Thuoc</a> |
<a href="themthuocmoi.jsp">Them thuoc moi</a> |
<a href="index.jsp">Trang chính</a>
</body>
</html>
