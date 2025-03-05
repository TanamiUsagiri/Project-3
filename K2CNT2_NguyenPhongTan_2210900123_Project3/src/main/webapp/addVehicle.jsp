<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm Xe</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
<h1 class="text-center">Thêm Xe Mới</h1>
<div class="card p-4 shadow-lg">
<form action="addVehicle" method="post">
    Hãng xe: <input class="form-control" type="text" name="vehicleBrand" required><br>
    Mẫu xe: <input class="form-control" type="text" name="vehicleModel" required><br>
    Giá: <input class="form-control" type="number" name="vehiclePrice" required><br>
    Năm sản xuất: <input class="form-control" type="number" name="vehicleYear" required><br>
    Trạng thái: 
    <select class="form-select" name="vehicleStatus">
        <option value="available">Còn hàng</option>
        <option value="sold">Đã bán</option>
    </select><br>
    <button class="btn btn-primary" type="submit">Thêm</button>
    <a class="btn btn-secondary" href="motorbikes">Quay về trang chủ</a>
</form>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
