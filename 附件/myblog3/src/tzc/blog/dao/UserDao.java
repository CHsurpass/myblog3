package tzc.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tzc.blog.util.DBUtil;

public class UserDao {
	public boolean isValid(String username,String password) {
		boolean valid = false;
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement stat = conn.prepareStatement("select * from user where username=? and password=?");
			stat.setString(1,username);
			stat.setString(2,password);
			ResultSet rs = stat.executeQuery();
			if(rs.next()) valid = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return valid;
	}
}
