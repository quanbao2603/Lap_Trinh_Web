<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager-Category</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/categories.css">
</head>
<body>

	<div class="header">
		<form method="get" action="">
			<input type="text" name="search" placeholder="Search">
			<button type="submit">Search</button>
		</form>
		<button class="btn-add" onclick="openAddModal()">Thêm danh
			mục</button>
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
					<td><a
						onclick="openUpdateModal(${cate.id}, '${cate.categoryname}')">Cập
							nhật</a> | <a onclick="confirmDelete(${cate.id})">Xóa</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<!-- Add Modal -->
	<div id="addModal" class="modal">
		<div class="modal-content">
			<span class="close" onclick="closeModal('addModal')">&times;</span>
			<h3>Thêm danh mục</h3>
			<form
				action="${pageContext.request.contextPath}/admin/home/admin-categories/add"
				method="post">
				<input type="text" name="categoryname" placeholder="Tên danh mục"
					required>
				<button type="submit">Thêm</button>
			</form>
		</div>
	</div>

	<!-- Update Modal -->
	<div id="updateModal" class="modal">
		<div class="modal-content">
			<span class="close" onclick="closeModal('updateModal')">&times;</span>
			<h3>Cập nhật danh mục</h3>
			<form
				action="${pageContext.request.contextPath}/admin/home/admin-categories/edit"
				method="post">
				<input type="hidden" name="id" id="updateId"> <input
					type="text" name="categoryname" id="updateName" required>
				<button type="submit">Cập nhật</button>
			</form>
		</div>
	</div>

	<!-- Delete form (ẩn) -->
	<form id="deleteForm"
		action="${pageContext.request.contextPath}/admin/home/admin-categories/delete"
		method="post" style="display: none;">
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