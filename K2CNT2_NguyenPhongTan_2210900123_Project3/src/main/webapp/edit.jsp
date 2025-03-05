<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sửa xe</title>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
</head>
<body>
<div class="container mt-5">
<h1 class="text-center">Chỉnh Sửa Xe</h1>
<div class="card p-4 shadow-lg">
<form action="update" method="post">
    <input type="hidden" name="id" value="${param.id}">
    Hãng xe: <input class="form-control" type="text" name="brand" value="${param.brand} "><br>
    Mẫu xe: <input class="form-control" type="text" name="model" value="${param.model}"><br>
    Giá: <input class="form-control" type="text" name="price" value="${param.price}"><br>
    Năm sản xuất: <input class="form-control" type="text" name="year" value="${param.year}"><br>
    Trạng thái: <input class="form-control" type="text" name="status" value="${param.status}"><br>
    <button type="submit" class="btn btn-success">Cập nhật</button>
    <a href="motorbikes" class="btn btn-secondary">Quay về</a>
</form>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
