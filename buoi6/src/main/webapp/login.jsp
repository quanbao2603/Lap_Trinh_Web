<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/login.css">
</head>
<body>
    <div class="login-container">
        <h2>Đăng nhập</h2>
        <form action="<%=request.getContextPath()%>/login" method="post">
            <div class="form-group">
                <label for="username">Tên đăng nhập</label>
                <input type="text" id="username" name="username" required>
            </div>

            <div class="form-group">
                <label for="password">Mật khẩu</label>
                <input type="password" id="password" name="password" required>
            </div>

            <button type="submit" class="btn">Đăng nhập</button>
        </form>

        <% 
            String error = (String) request.getAttribute("error");
            if (error != null) {
        %>
            <p class="error"><%= error %></p>
        <% } %>
    </div>
</body>
</html>