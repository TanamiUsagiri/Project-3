<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="NavPage.jsp"/>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách Yêu Cầu</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center">Danh sách Yêu Cầu</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>User ID</th>
            <th>Vehicle ID</th>
            <th>Message</th>
            <th>Created At</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listRequests}" var="req">
            <tr>
                <td>${req.requestId}</td>
                <td>${req.userId}</td>
                <td>${req.vehicleId}</td>
                <td>${req.message}</td>
                <td>${req.createdAt}</td>
                <td>
    <a class="btn btn-warning" href="editRequest.jsp?id=${req.requestId}">Sửa</a>
	<a class="btn btn-danger" href="deleteRequest?id=${req.requestId}" onclick="return confirm('Bạn có chắc chắn muốn xóa?');">Xóa</a>
</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="addRequest.jsp" class="btn btn-primary">Thêm Yêu Cầu</a>
</div>
</body>
</html>
