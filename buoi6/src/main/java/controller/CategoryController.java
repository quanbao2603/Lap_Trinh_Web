package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CategoryServiceImpl;
import service.interfaces.CategoryService;

import java.io.IOException;
import java.util.List;

import entity.Category;
import entity.Users;

@WebServlet({
    // Admin
    "/admin/home/admin-categories", 
    "/admin/home/admin-categories/add",
    "/admin/home/admin-categories/edit",  
    "/admin/home/admin-categories/delete",

    // User
    "/user/home/user-categories", 
    "/user/home/user-categories/add",
    "/user/home/user-categories/edit",  
    "/user/home/user-categories/delete",

    // Manager
    "/manager/home/manager-categories", 
    "/manager/home/manager-categories/add",
    "/manager/home/manager-categories/edit",  
    "/manager/home/manager-categories/delete"
})
public class CategoryController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryService cateService = new CategoryServiceImpl();   

    public CategoryController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        Users currentUser = (Users) req.getSession().getAttribute("user");
        Integer role = (currentUser != null) ? currentUser.getRole() : null;

        List<Category> list = cateService.findByRole(role);
        req.setAttribute("listcate", list);

        if (path.startsWith("/admin/")) {
            req.getRequestDispatcher("/admin/home/admin-categories.jsp").forward(req, resp);
        } else if (path.startsWith("/user/")) {
            req.getRequestDispatcher("/user/home/user-categories.jsp").forward(req, resp);
        } else if (path.startsWith("/manager/")) {
            req.getRequestDispatcher("/manager/home/manager-categories.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        Users currentUser = (Users) req.getSession().getAttribute("user");
        Integer role = (currentUser != null) ? currentUser.getRole() : null;

        if (path.endsWith("/add")) {
            String name = req.getParameter("categoryname");
            Category cate = new Category();
            cate.setCategoryname(name);
            cate.setRole(role); // gán role theo user login
            cateService.create(cate);

        } else if (path.endsWith("/edit")) {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("categoryname");

            Category cate = cateService.findById(id);
            if (cate != null) {
                cate.setCategoryname(name);
                cateService.update(cate);
            }

        } else if (path.endsWith("/delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            cateService.delete(id);
        }
        
        if (path.startsWith("/admin/")) {
            resp.sendRedirect(req.getContextPath() + "/admin/home/admin-categories");
        } else if (path.startsWith("/user/")) {
            resp.sendRedirect(req.getContextPath() + "/user/home/user-categories");
        } else if (path.startsWith("/manager/")) {
            resp.sendRedirect(req.getContextPath() + "/manager/home/manager-categories");
        }
    }
}