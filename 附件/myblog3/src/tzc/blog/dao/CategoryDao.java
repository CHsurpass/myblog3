package tzc.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tzc.blog.bean.Category;
import tzc.blog.util.DBUtil;

public class CategoryDao {

	public void addCategory(String title) {
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement stat = conn
					.prepareStatement("insert into category (title,created_at)values(?,?)");
			stat.setString(1, title);
			stat.setTimestamp(2, new Timestamp(new Date().getTime()));
			stat.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}

	public boolean exists(String title) {
		boolean isExists = false;
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement stat = conn
					.prepareStatement("select * from category where title = ?");
			stat.setString(1, title);
			ResultSet rs = stat.executeQuery();
			if (rs.next()) {
				isExists = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return isExists;
	}

	public List<Category> getAll() {
		List<Category> categories = new ArrayList<Category>();
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement stat = conn
					.prepareStatement("select * from category");
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setCreatedAt(new Date(rs.getTimestamp("created_at")
						.getTime()));
				category.setTitle(rs.getString("title"));
				categories.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return categories;
	}

	public Category get(int id) {
		Category category = new Category();
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement stat = conn
					.prepareStatement("select * from category where id = ?");
			stat.setInt(1, id);
			ResultSet rs = stat.executeQuery();
			if (rs.next()) {
				category.setId(rs.getInt("id"));
				category.setCreatedAt(new Date(rs.getTimestamp("created_at")
						.getTime()));
				category.setTitle(rs.getString("title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return category;
	}
	
	public void edit(int id,String title) {
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement stat = conn
					.prepareStatement("update category set title=? where id = ?");
			stat.setString(1, title);
			stat.setInt(2, id);
			stat.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}
	
	public void delete(int id) {
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement stat = conn
					.prepareStatement("delete from category where id = ?");
			stat.setInt(1, id);
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}
}
