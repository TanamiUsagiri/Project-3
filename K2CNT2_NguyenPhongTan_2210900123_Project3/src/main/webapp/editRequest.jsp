<%@ page import="beans.RequestDAO, beans.Request" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page language="java" %>

<%
    String requestId = request.getParameter("id");
    Request requestData = null;

    if (requestId != null && !requestId.isEmpty()) {
        try {
            int id = Integer.parseInt(requestId);
            RequestDAO requestDAO = new RequestDAO();
            requestData = requestDAO.getRequestById(id);
            System.out.println("Request ID: " + id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Chỉnh sửa yêu cầu</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="card">
        <div class="card-header bg-primary text-white">
            <h3 class="text-center">Chỉnh sửa Yêu Cầu</h3>
        </div>
        <div class="card-body">
            <% if (requestData != null) { %>
            <form action="updateRequest" method="post">
                <input type="hidden" name="requestId" value="<%= requestData.getRequestId() %>">
                <div class="mb-3">
                    <label for="message" class="form-label">Lời nhắn:</label>
                    <textarea class="form-control" name="message" rows="4" required><%= requestData.getMessage() %></textarea>
                </div>
                <div class="d-flex justify-content-between">
                    <button type="submit" class="btn btn-success">Cập nhật</button>
                    <a href="requests" class="btn btn-secondary">Quay lại</a>
                </div>
            </form>
            <% } else { %>
            <div class="alert alert-danger text-center">
                Không tìm thấy yêu cầu!
            </div>
            <div class="text-center">
                <a href="requests" class="btn btn-primary">Quay lại</a>
            </div>
            <% } %>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
