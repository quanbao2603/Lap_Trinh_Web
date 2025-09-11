package control;

import dao.ProfileDAO;
import entity.UserProfile;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;

@WebServlet("/profile")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1MB
        maxFileSize = 10 * 1024 * 1024,          // 10MB
        maxRequestSize = 50 * 1024 * 1024)       // 50MB
public class ProfileServlet extends HttpServlet {
    private ProfileDAO dao = new ProfileDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Lấy profile user (tạm hardcode id=1)
        UserProfile profile = dao.getById(1);
        if (profile == null) {
            profile = new UserProfile();
            profile.setId(0);
        }
        req.setAttribute("profile", profile);
        req.getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String fullname = req.getParameter("fullname");
        String phone = req.getParameter("phone");

        // upload ảnh
        Part filePart = req.getPart("image");
        String fileName = null;

        if (filePart != null && filePart.getSize() > 0) {
            fileName = System.currentTimeMillis() + "_" + filePart.getSubmittedFileName();
            String uploadPath = getServletContext().getRealPath("/uploads");
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) uploadDir.mkdir();

            filePart.write(uploadPath + File.separator + fileName);
        }

        // lấy profile hiện có (tạm hardcode id=1)
        UserProfile profile = dao.getById(1);
        if (profile == null) {
            profile = new UserProfile();
        }

        profile.setFullname(fullname);
        profile.setPhone(phone);
        if (fileName != null) {
            profile.setImage(fileName);
        }

        dao.saveOrUpdate(profile);

        resp.sendRedirect(req.getContextPath() + "/profile");
    }
}
