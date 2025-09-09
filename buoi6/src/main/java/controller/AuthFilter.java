package controller;

import entity.Users;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		System.out.println("[AuthFilter] Request URI: " + uri);
		if (uri.equals(contextPath + "/login") || uri.endsWith("login.jsp") || uri.contains("/css/")
				|| uri.contains("/js/") || uri.contains("/images/")) {
			chain.doFilter(request, response);
			return;
		}
		HttpSession session = req.getSession(false);
		Users user = (session != null) ? (Users) session.getAttribute("user") : null;
		Integer role = (session != null) ? (Integer) session.getAttribute("role") : null;

		if (user == null || role == null) {
			System.out.println("[AuthFilter] Chưa đăng nhập, redirect về login.jsp");
			resp.sendRedirect(contextPath + "/login.jsp");
			return;
		}
	}
}