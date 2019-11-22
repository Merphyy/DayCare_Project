package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import util.DBUtils;

public class UserDAO {
	
	public Integer login(String username, String pwd) throws Exception{
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			String sql="select * from User";
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			while(rs.next()) {
				if(username.equals(rs.getString("username"))&& pwd.equals( rs.getString("password"))) {
					return rs.getInt("teacherId");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, stat, rs);
		}
		return -1;
	}
	
	
	
	public List<User> findAll() throws Exception{
		List<User> users = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			String sql="select * from User";
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			while(rs.next()) {
				
				Integer teacherId = rs.getInt("teacherId");
				String username = rs.getString("username");
				String pwd = rs.getString("password");
				
				
				User user = new User();
				user.setTeacherId(teacherId);
				user.setUsername(username);
				user.setPwd(pwd);
				
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, stat, rs);
		}
		return users;
	}
	
	

}
