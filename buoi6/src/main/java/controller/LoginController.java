package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UsersServiceImpl;
import service.interfaces.UsersService;

import java.io.IOException;

import entity.Users;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsersService usersService = new UsersServiceImpl();

    public LoginController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Users user = usersService.login(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());

            switch (user.getRole()) {
                case 1:
                    response.sendRedirect(request.getContextPath() + "/user/home/user-categories");
                    break;
                case 2:
                    response.sendRedirect(request.getContextPath() + "/admin/home/admin-categories");
                    break;
                case 3:
                    response.sendRedirect(request.getContextPath() + "/manager/home/manager-categories");
                    break;
                default:
                    request.setAttribute("error", "Vai trò không hợp lệ!");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "Sai tài khoản hoặc mật khẩu!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}