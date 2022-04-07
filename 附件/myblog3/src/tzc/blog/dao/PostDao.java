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
import tzc.blog.bean.Post;
import tzc.blog.util.DBUtil;

public class PostDao {
	public void addPost(String title,String content) {
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement stat = conn
					.prepareStatement("insert into post (title,content,categroy_id,view_count,created_at)values(?,?,?,?,?)");
			stat.setString(1, title);
			stat.setString(2, content);
			stat.setInt(3, 1);
			stat.setInt(4, 0);
			stat.setTimestamp(5, new Timestamp(new Date().getTime()));
			stat.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}
	public List<Post> getAll() {
		List<Post> posts = new ArrayList<Post>();
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement stat = conn
					.prepareStatement("select * from post");
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				Post post = new Post();
				post.setId(rs.getInt("id"));
				post.setCreatedAt(new Date(rs.getTimestamp("created_at")
						.getTime()));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setViewCount(rs.getInt("view_count"));
				posts.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return posts;
	}
	
	public void delete(int id) {
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement stat = conn
					.prepareStatement("delete from post where id = ?");
			stat.setInt(1, id);
			stat.executeUpdate();
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
					.prepareStatement("select * from post where title = ?");
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
	
	public Post get(int id) {
		Post post = new Post();
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement stat = conn
					.prepareStatement("select * from post where id = ?");
			stat.setInt(1, id);
			ResultSet rs = stat.executeQuery();
			if (rs.next()) {
				post.setId(rs.getInt("id"));
				post.setCreatedAt(new Date(rs.getTimestamp("created_at")
						.getTime()));
				post.setTitle(rs.getString("title"));
				post.setViewCount(rs.getInt("view_count"));
				post.setContent(rs.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return post;
	}
	
	public void edit(int id,String content) {
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement stat = conn
					.prepareStatement("update post set content=? where id = ?");
			stat.setString(1, content);
			stat.setInt(2, id);
			stat.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}
}
