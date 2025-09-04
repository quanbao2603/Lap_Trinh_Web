package controller.admin;

import java.io.IOException;
import java.util.List;
import entity.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CategoryService;
import service.Impl.CategoryServiceImpl;

@WebServlet({
    "/admin/categories", 
    "/admin/categories/add",
    "/admin/categories/edit",  
    "/admin/categories/delete"  
})
public class CategoryController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        String path = req.getServletPath();

        if (path.equals("/admin/categories")) {
            List<Category> list = cateService.findAll();
            req.setAttribute("listcate", list);
            req.getRequestDispatcher("/views/admin/categories.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        String path = req.getServletPath();

        if (path.equals("/admin/categories/add")) {
            String name = req.getParameter("categoryname");
            Category cate = new Category();
            cate.setCategoryname(name);
            cateService.create(cate);
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        } 
        else if (path.equals("/admin/categories/edit")) {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("categoryname");

            Category cate = cateService.findById(id);
            if (cate != null) {
                cate.setCategoryname(name);
                cateService.update(cate);
            }
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        } 
        else if (path.equals("/admin/categories/delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            cateService.delete(id);
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        }
    }
}
