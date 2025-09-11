<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title><sitemesh:write property="title"/></title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" 
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body>
<div class="container mt-4">
    <header class="mb-3">
        <h2 class="text-primary">ProfileApp</h2>
        <hr/>
    </header>

    <main>
        <sitemesh:write property="body"/>
    </main>

    <footer class="mt-4 text-center text-muted">
        <hr/>
        <small>© 2025 ProfileApp</small>
    </footer>
</div>
</body>
</html>
