package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Class;
import entity.Teacher;
import util.DBUtils;

public class ClassDAO {
	
	
	public void resetCapacity(entity.Class c) throws Exception {
	Connection conn = null;
	PreparedStatement stat = null;
	try {
		conn = DBUtils.getConn();
		String sql = "update Class set C_capacity = 0 where classId = ?";
		stat = conn.prepareStatement(sql);
		stat.setInt(1, c.getClassId());
		stat.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
		throw e;
	}finally {
		DBUtils.close(conn, stat, null);
	}
	
}
	
	
	public void updateCapacity(entity.Class c) throws Exception {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = DBUtils.getConn();
			String sql = "update Class set C_capacity = ? where classId = ?";
			stat = conn.prepareStatement(sql);
			
			stat.setInt(1, c.getC_capacity());
			stat.setInt(2, c.getClassId());
			
			
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, stat, null);
		}
		
	}
	
	
	public List<Class> findAll() throws Exception{
		
		List<Class> c = new ArrayList<Class>();
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			String sql="select * from Class";
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			
			while(rs.next()) {
				
				int classId = rs.getInt("classId");
				int C_capacity = rs.getInt("C_capacity");
				int C_maxCapacity = rs.getInt("C_maxCapacity");			
				Class Class = new Class();
				Class.setClassId(classId);;
				Class.setC_capacity(C_capacity);
				Class.setC_maxCapacity(C_maxCapacity);
				
				c.add(Class);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, stat, rs);
		}
		return c;
	}
	
}
