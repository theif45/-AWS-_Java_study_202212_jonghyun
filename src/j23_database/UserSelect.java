package j23_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import usermanagement.entity.User;

public class UserSelect {

	private DBConnectionMgr pool;

	public UserSelect() {
		pool = DBConnectionMgr.getInstance();
	}

	public User findUserByUsername(String username) {
		User user = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = pool.getConnection();

			String sql = "select user_id, username, password, name, email from user_mst where username = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);

			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = User.builder()
						.userId(rs.getInt(1))
						.username(rs.getString(2))
						.password(rs.getString(3))
						.name(rs.getString(4))
						.email(rs.getString(5))
						.build();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}

		return user;
	}

	public static void main(String[] args) {
		UserSelect userSelect = new UserSelect();

		User user = userSelect.findUserByUsername("aaa");

		System.out.println(user);
		
		
	}
}
