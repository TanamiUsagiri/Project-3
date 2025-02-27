<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    response.sendRedirect("frontend/index.html");
%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vehicle List</title>
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
<%--         <jsp:useBean id="vehicleList" scope="request" class="java.util.List"/>
        <jsp:forEach var="vehicle" items="${vehicleList}"> --%>
            <tr>
                <td>${vehicle.vehicleId}</td>
                <td>${vehicle.brand}</td>
                <td>${vehicle.model}</td>
                <td>${vehicle.price}</td>
                <td>${vehicle.year}</td>
                <td>${vehicle.status}</td>
            </tr>
        <%-- </jsp:forEach> --%>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>