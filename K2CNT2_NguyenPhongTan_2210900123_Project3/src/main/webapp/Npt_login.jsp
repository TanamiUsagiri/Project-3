<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
    .html, body {
  height: 100%;
  margin: 0;
  padding: 0;
  display: flex;
  justify-content: center; /* Căn giữa theo chiều ngang */
  align-items: center; /* Căn giữa theo chiều dọc */
  background-color: #f3f4f6; /* Màu nền */
  min-height: 100vh; /* Chiều cao tối thiểu bằng 100% màn hình */
}
	.container {
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}
    .form {
  background-color: #fff;
  display: block;
  padding: 1rem;
  max-width: 350px;
  border-radius: 0.5rem;
  box-shadow: 0 10px 15px -3px rgba(0, 0, 0, 0.1), 0 4px 6px -2px rgba(0, 0, 0, 0.05);
}

.form-title {
  font-size: 1.25rem;
  line-height: 1.75rem;
  font-weight: 600;
  text-align: center;
  color: #000;
}

.input-container {
  position: relative;
}

.input-container input, .form button {
  outline: none;
  border: 1px solid #e5e7eb;
  margin: 8px 0;
}

.input-container input {
  background-color: #fff;
  padding: 1rem;
  padding-right: 3rem;
  font-size: 0.875rem;
  line-height: 1.25rem;
  width: 300px;
  border-radius: 0.5rem;
  box-shadow: 0 1px 2px 0 rgba(0, 0, 0, 0.05);
}

.submit {
  display: block;
  padding-top: 0.75rem;
  padding-bottom: 0.75rem;
  padding-left: 1.25rem;
  padding-right: 1.25rem;
  background-color: #4F46E5;
  color: #ffffff;
  font-size: 0.875rem;
  line-height: 1.25rem;
  font-weight: 500;
  width: 100%;
  border-radius: 0.5rem;
  text-transform: uppercase;
}

.signup-link {
  color: #6B7280;
  font-size: 0.875rem;
  line-height: 1.25rem;
  text-align: center;
}

.signup-link a {
  text-decoration: underline;
}
    </style>
</head>
<body>
<div class="container">
    <form class="form" action="LoginServlet" method="post">
        <p class="form-title">Đăng nhập</p>
        <div class="input-container">
            <input type="email" name="email" class="form-control" placeholder="Nhập Email" required>
        </div>
        <div class="input-container">
            <input type="password" name="password" class="form-control" placeholder="Nhập Mật khẩu" required>
        </div>
        <% if (request.getAttribute("error") != null) { %>
        <div class="alert alert-danger">
            <%= request.getAttribute("error") %>
        </div>
        <% } %>
        <button type="submit" class="submit">Đăng nhập</button>
        <p class="signup-link">
            Chưa có tài khoản?
            <a href="Npt_register.jsp">Đăng kí</a>
        </p>
    </form>
</div>
</body>
</html>
