package test;

import entity.Users;
import service.UsersServiceImpl;
import service.interfaces.UsersService;

public class TestLogin {
    public static void main(String[] args) {
        UsersService usersService = new UsersServiceImpl();
        String username = "admin01";   
        String password = "123456";
        Users user = usersService.login(username, password);
        if (user != null) {
            System.out.println("Đăng nhập thành công!");
            System.out.println("ID: " + user.getId());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Role: " + user.getRole());
        } else {
            System.out.println("Sai tài khoản hoặc mật khẩu!");
        }
    }
}