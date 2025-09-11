# Lập trình Web - Tổng hợp bài tập

**Sinh viên:** Nguyễn Quân Bảo  
**Mã sinh viên:** 23110181  

**Môn học:** Lập trình Web  
**Repo:** Tổng hợp các bài tập theo tuần (chiếm 50% điểm quá trình)

---

## Chi tiết các bài tập

### Bài 2: Login cơ bản
- Thực hiện chức năng login cơ bản  
- Lưu thông tin người dùng bằng **cookie**

### Bài 3: Login & Register nâng cao
- Thực hiện chức năng **login** và **register**  
- Kết nối với **cơ sở dữ liệu** để lưu trữ thông tin người dùng

### Bài 4: Logout, Forget Password & CRUD Category
- Thực hiện chức năng **logout**  
- Thực hiện **quên mật khẩu (forget password)**  
- Thực hiện **CRUD** trên bảng `category` trong cơ sở dữ liệu

### Bài 5: Thực hiện CRUD API với Servlet JPA
- Thực hiện chức năng **crud**  như **insert**, **delete**, **update**

### Bài 6: Thực hiện viết bằng JPA
- Thực hiện trên database có 02 bản: Users và Category, Một user có nhiều `category`.
- Thực hiện đăng nhập với roleid tương ứng (1-user, 2-manager, 3- admin), nếu đăng nhập thành công thì chuyển hướng về URL theo role tương ứng như sau (user: /user/home ; manager: /manager/home; admin: /admin/home)
- Dùng Filter để lọc URL tương ứng với RoleID.
- Trang home của role user và admin sẽ hiển thị danh sách tất cả category, trang home của role manager sẽ hiển thị danh sách các category của userid tương ứng.
- Thực hiện thêm, sửa, xem, xóa category của chính mình tạo ra theo role.

### Bài 7: Thực hiện thiết kế layout web
- Thự hiện cấu hình Sitemesh Decorator 3 với Template Bootstrap.
- Làm chức năng profile để update: fullname, phone, images (có sử dụng upload file bằng multipart)

## Cấu trúc repo (tham khảo)