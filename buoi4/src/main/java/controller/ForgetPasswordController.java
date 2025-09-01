package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import service.UserService;
import service.UserServiceImpl;

import java.io.IOException;

/**
 * Servlet implementation class ForgetPasswordController
 */
@WebServlet(urlPatterns = "/forget-password")
public class ForgetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgetPasswordController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// chuyển hướng sang form forget.jsp
		req.getRequestDispatcher("/forget.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String username = req.getParameter("username");
		String newPassword = req.getParameter("password");
		String confirmPassword = req.getParameter("confirmPassword");

		String alertMsg = "";

		if (username == null || username.isEmpty() || newPassword == null || newPassword.isEmpty()
				|| confirmPassword == null || confirmPassword.isEmpty()) {
			alertMsg = "Vui lòng nhập đầy đủ thông tin";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/forget.jsp").forward(req, resp);
			return;
		}

		if (!newPassword.equals(confirmPassword)) {
			alertMsg = "Mật khẩu xác nhận không khớp";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/forget.jsp").forward(req, resp);
			return;
		}

		UserService service = new UserServiceImpl();
		User user = service.findByUsername(username);

		if (user == null) {
			alertMsg = "Tài khoản không tồn tại";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/forget.jsp").forward(req, resp);
			return;
		}

		// cập nhật mật khẩu mới vào database
		boolean updated = service.updatePassword(username, newPassword);

		if (updated) {
			req.setAttribute("success", "Đổi mật khẩu thành công! Vui lòng đăng nhập lại.");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		} else {
			alertMsg = "Có lỗi xảy ra, vui lòng thử lại";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/forget.jsp").forward(req, resp);
		}
	}
}
