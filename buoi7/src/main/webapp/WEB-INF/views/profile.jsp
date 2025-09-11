<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="container mt-4">
<h2>Profile Update</h2>
<form action="${pageContext.request.contextPath}/profile" 
      method="post" enctype="multipart/form-data" class="mt-3">

    <div class="mb-3">
        <label class="form-label">Fullname</label>
        <input type="text" name="fullname" class="form-control"
               value="${profile.fullname}" required/>
    </div>

    <div class="mb-3">
        <label class="form-label">Phone</label>
        <input type="text" name="phone" class="form-control"
               value="${profile.phone}" required/>
    </div>

    <div class="mb-3">
        <label class="form-label">Image</label><br>
        <c:if test="${not empty profile.image}">
            <img src="${pageContext.request.contextPath}/uploads/${profile.image}" 
                 alt="Profile Image" width="120" class="mb-2"><br>
        </c:if>
        <input type="file" name="image" class="form-control"/>
    </div>

    <button type="submit" class="btn btn-primary">Save</button>
</form>
</body>
</html>
