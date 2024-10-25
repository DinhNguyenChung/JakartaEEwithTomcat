<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 24/10/2024
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Thêm thuốc mới</h1>
<form  method="post" action="QuanLyThuocServlet">
    <p>Nhập tên thuoc </p>
    <input type="text" name="tenThuoc" required> <br>
    <p>Nhập giá </p>
    <input type="text" name="gia" required> <br>
    <p>Nhập ngày sản xuất </p>
    <input type="date" name="nsx" required> <br>
    <p>Nhập hạn sử dụng </p>
    <input type="date" name="hsd" required> <br>
    <p>Nhập trạng thái </p>
    <input type="text" name="state" required> <br>
    <p>Nhập mã loại </p>
    <input type="text" name="maLoai" required> <br>
    <input type="hidden" name="action" value="themthuocmoi"> <br>
    <input type="submit" value="Thêm Mới">




</form>
    <a href="QuanLyThuocServlet?action=quanlythuoc">Quan Ly Thuoc</a> |
    <a href="QuanLyThuocServlet?action=quanlyloaithuoc">Quan Ly loai Thuoc</a> |
    <a href="index.jsp">Trang chính</a>
</body>
</html>
