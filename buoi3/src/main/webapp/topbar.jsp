<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Topbar</title>
    <!-- Bootstrap CSS (phiên bản 5) -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome cho icon -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <!-- Logo / Brand -->
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">MyShop</a>

        <!-- Toggle button cho mobile -->
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTop" aria-controls="navbarTop" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Menu -->
        <div class="collapse navbar-collapse" id="navbarTop">
            <ul class="navbar-nav ms-auto align-items-center">
                <c:choose>
                    <!-- Chưa đăng nhập -->
                    <c:when test="${sessionScope.account == null}">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/login">Đăng nhập</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/register">Đăng ký</a>
                        </li>
                    </c:when>
                    <!-- Đã đăng nhập -->
                    <c:otherwise>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                <i class="fa fa-user"></i> ${sessionScope.account.fullName}
                            </a>
                            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="userDropdown">
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/member/myaccount">Tài khoản</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Đăng xuất</a></li>
                            </ul>
                        </li>
                    </c:otherwise>
                </c:choose>

                <!-- Nút tìm kiếm luôn hiện -->
                <li class="nav-item ms-2">
                    <a class="nav-link" href="#"><i class="fa fa-search"></i></a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
