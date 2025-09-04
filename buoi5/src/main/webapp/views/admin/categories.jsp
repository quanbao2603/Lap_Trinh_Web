<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách danh mục</title>
<style>
    body { font-family: Arial, sans-serif; margin: 20px; }
    .header { margin-bottom: 10px; overflow: hidden; }
    .header form { float: left; }
    .header input[type="text"] { padding: 5px; }
    .header button { padding: 5px 10px; margin-left: 5px; }
    .btn-add {
        float: right;
        padding: 6px 12px;
        background-color: #0d6efd;
        color: white;
        border: none;
        cursor: pointer;
        border-radius: 4px;
    }
    .btn-add:hover { background-color: #0b5ed7; }
    .box-title { background-color: #e6f3fa; padding: 8px; font-weight: bold; border: 1px solid #cde0ee; margin-top: 15px; }
    table { width: 100%; border-collapse: collapse; margin-top: 0; }
    th, td { border: 1px solid #ccc; padding: 6px; text-align: left; }
    th { background-color: #f5f5f5; }
    a { text-decoration: none; color: blue; margin: 0 3px; cursor: pointer; }
    a:hover { text-decoration: underline; }

    /* Modal style */
    .modal { display: none; position: fixed; z-index: 1;
             left: 0; top: 0; width: 100%; height: 100%;
             background-color: rgba(0,0,0,0.5);}
    .modal-content { background: #fff; margin: 10% auto; padding: 20px;
                     border-radius: 6px; width: 400px; position: relative;}
    .close { position: absolute; top: 8px; right: 12px; font-size: 20px;
             font-weight: bold; color: #333; cursor: pointer;}
    .close:hover { color: red; }
    .modal-content input[type="text"] { width: 100%; padding: 6px; margin: 10px 0; }
    .modal-content button { background-color: #0d6efd; color: white; border: none;
                            padding: 6px 12px; cursor: pointer; border-radius: 4px;}
    .modal-content button:hover { background-color: #0b5ed7; }
</style>
</head>
<body>

<div class="header">
    <form method="get" action="">
        <input type="text" name="search" placeholder="Search">
        <button type="submit">Search</button>
    </form>
    <button class="btn-add" onclick="openAddModal()">Thêm danh mục</button>
</div>

<div class="box-title">Danh sách danh mục</div>

<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Tên danh mục</th>
            <th>Hành động</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${listcate}" var="cate">
            <tr>
                <td>${cate.id}</td>
                <td>${cate.categoryname}</td>
                <td>
                    <a onclick="openUpdateModal(${cate.id}, '${cate.categoryname}')">Cập nhật</a> | 
                    <a onclick="confirmDelete(${cate.id})">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<!-- Add Modal -->
<div id="addModal" class="modal">
  <div class="modal-content">
    <span class="close" onclick="closeModal('addModal')">&times;</span>
    <h3>Thêm danh mục</h3>
    <form action="${pageContext.request.contextPath}/admin/categories/add" method="post">
        <input type="text" name="categoryname" placeholder="Tên danh mục" required>
        <button type="submit">Thêm</button>
    </form>
  </div>
</div>

<!-- Update Modal -->
<div id="updateModal" class="modal">
  <div class="modal-content">
    <span class="close" onclick="closeModal('updateModal')">&times;</span>
    <h3>Cập nhật danh mục</h3>
    <form action="${pageContext.request.contextPath}/admin/categories/edit" method="post">
        <input type="hidden" name="id" id="updateId">
        <input type="text" name="categoryname" id="updateName" required>
        <button type="submit">Cập nhật</button>
    </form>
  </div>
</div>

<!-- Delete form (ẩn) -->
<form id="deleteForm" action="${pageContext.request.contextPath}/admin/categories/delete" method="post" style="display:none;">
    <input type="hidden" name="id" id="deleteId">
</form>

<script>
function openAddModal() {
    document.getElementById("addModal").style.display = "block";
}
function openUpdateModal(id, name) {
    document.getElementById("updateId").value = id;
    document.getElementById("updateName").value = name;
    document.getElementById("updateModal").style.display = "block";
}
function closeModal(id) {
    document.getElementById(id).style.display = "none";
}
window.onclick = function(event) {
    let addModal = document.getElementById("addModal");
    let updateModal = document.getElementById("updateModal");
    if (event.target == addModal) closeModal('addModal');
    if (event.target == updateModal) closeModal('updateModal');
}
function confirmDelete(id) {
    if (confirm("Bạn có chắc chắn muốn xóa danh mục này?")) {
        document.getElementById("deleteId").value = id;
        document.getElementById("deleteForm").submit();
    }
}
</script>

</body>
</html>
