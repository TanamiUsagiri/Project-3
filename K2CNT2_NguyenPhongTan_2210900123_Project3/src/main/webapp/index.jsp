<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Danh sách xe</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center">Danh sách xe</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Hãng xe</th>
            <th>Mẫu xe</th>
            <th>Giá bán</th>
            <th>Năm sản xuất</th>
            <th>Trạng thái</th>
        </tr>	
        </thead>
        <tbody>
        <c:forEach items="${listMotorbike}" var="mb">
            <tr>
                <td>${mb.vehicleId}</td>
                <td>${mb.brand}</td>
                <td>${mb.model}</td>
                <td>${mb.price}</td>
                <td>${mb.year}</td>
                <td>${mb.status}</td>
                <td>
    				<a href="delete?id=${mb.vehicleId}" class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xóa không?');">Xóa</a>
    				<a href="edit.jsp?id=${mb.vehicleId}&brand=${mb.brand}&model=${mb.model}&price=${mb.price}&year=${mb.year}&status=${mb.status}" class="btn btn-warning">Sửa</a>
    				<a href="addVehicle.jsp"><button class="btn btn-primary">Thêm Xe</button></a>
				</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
