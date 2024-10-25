<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<div style="flex: 1;align-items: center">
    <h1><%= "Dinh Nguyen Chung 21127891!" %>
    </h1>
    <hr/>
    <a href="QuanLyThuocServlet?action=quanlyloaithuoc">Danh sach loai thuoc</a> |
    <a href="QuanLyThuocServlet?action=quanlythuoc">Danh sach thuo</a> |
    <a href="QuanLyThuocServlet?action=themthuocmoi">Them thuoc moi</a> |
</div>


</body>
</html>