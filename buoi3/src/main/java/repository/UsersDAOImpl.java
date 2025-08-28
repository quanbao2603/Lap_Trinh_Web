package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

import model.Users;

public class UsersDAOImpl implements UsersDAO  {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public Users get(String username) {
		String sql = "SELECT * FROM `users` WHERE username = ?";
		try {
		Connection conn = JDBCUtil.getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		rs = ps.executeQuery();
		while (rs.next()) {
		Users user = new Users();
		user.setId(rs.getInt("id"));
		user.setEmail(rs.getString("email"));
		user.setUserName(rs.getString("username"));
		user.setFullName(rs.getString("fullname"));
		user.setPassWord(rs.getString("password"));
		user.setAvatar(rs.getString("avatar"));
		user.setRoleid(Integer.parseInt(rs.getString("roleid")));
		user.setPhone(rs.getString("phone"));
		user.setCreatedDate(rs.getDate("createdDate"));
		return user; }
		} catch (Exception e) {e.printStackTrace(); }
		return null;

	}

}
