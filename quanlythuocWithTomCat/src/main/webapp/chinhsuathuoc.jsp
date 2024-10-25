<%@ page import="vn.edu.iuh.fit.quanlythuocwithtomcat.entities.Thuoc" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 25/10/2024
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Chinh sua thuoc</h1>
<%
    Thuoc thuoc = (Thuoc) session.getAttribute("thuoc");
%>
<form  method="post" action="QuanLyThuocServlet">
    <p>Ma thuoc </p>
    <input type="text" name="maThuoc" value="<%=thuoc.getMaThuoc()%>" required readonly> <br>
    <p>Tên thuoc </p>
    <input type="text" name="tenThuoc" value="<%=thuoc.getTenThuoc()%>" required> <br>
    <p>Giá </p>
    <input type="text" name="gia" value="<%=thuoc.getGia()%>" required> <br>
    <p>Ngày sản xuất </p>
    <input type="date" name="nsx" value="<%=thuoc.getNgaySX()%>" required> <br>
    <p>Hạn sử dụng </p>
    <input type="date" name="hsd" value="<%=thuoc.getNgayHH()%>" required> <br>
    <p>Trạng thái </p>
    <input type="text" name="state" value="<%=thuoc.getState()%>" required disabled> <br>
    <p>Mã loại </p>
    <input type="text" name="maLoai" value="<%=thuoc.getLoaiThuoc().getMaLoaiThuoc()%>" required> <br>
    <input type="hidden" name="action" value="update"> <br>
    <input type="submit" value="Update">




</form>
<a href="QuanLyThuocServlet?action=quanlythuoc">Quan Ly Thuoc</a> |
<a href="QuanLyThuocServlet?action=quanlyloaithuoc">Quan Ly loai Thuoc</a> |
<a href="index.jsp">Trang chính</a>
</body>
</html>

