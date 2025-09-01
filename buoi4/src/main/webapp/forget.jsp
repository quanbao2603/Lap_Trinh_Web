<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Quên Mật Khẩu</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">

	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-5">
				<div class="card shadow">
					<div class="card-body">
						<h2 class="text-center mb-4 text-muted">Đặt Lại Mật Khẩu</h2>

						<!-- Hiển thị thông báo lỗi -->
						<c:if test="${alert != null}">
							<div class="alert alert-danger text-center">${alert}</div>
						</c:if>

						<!-- Hiển thị thông báo thành công -->
						<c:if test="${success != null}">
							<div class="alert alert-success text-center">${success}</div>
						</c:if>

						<!-- Form quên mật khẩu -->
						<form action="${pageContext.request.contextPath}/forget-password" method="post">
							
							<div class="mb-3 input-group">
								<span class="input-group-text"><i class="fa fa-user"></i></span>
								<input type="text" class="form-control" name="username"
									placeholder="Nhập tài khoản" required>
							</div>

							<div class="mb-3 input-group">
								<span class="input-group-text"><i class="fa fa-lock"></i></span>
								<input type="password" class="form-control" name="password"
									placeholder="Mật khẩu mới" required>
							</div>

							<div class="mb-3 input-group">
								<span class="input-group-text"><i class="fa fa-check"></i></span>
								<input type="password" class="form-control" name="confirmPassword"
									placeholder="Xác nhận mật khẩu mới" required>
							</div>

							<button type="submit" class="btn btn-primary w-100">Đặt lại mật khẩu</button>
						</form>

						<p class="text-center mt-3">
							<a href="${pageContext.request.contextPath}/login">Quay lại đăng nhập</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>