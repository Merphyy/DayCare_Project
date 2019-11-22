package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Student;
import entity.Teacher;
import entity.User;
import util.DBUtils;

public class TeacherDAO {
	
	public void resetClassRoom(Teacher teacher) throws Exception {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = DBUtils.getConn();
			String sql = "update teacher set classroom = 0 where teacherId = ?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, teacher.getTeacherId());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, stat, null);
		}
		
	}
	
	public void updateClassRoom(Teacher teacher) throws Exception {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = DBUtils.getConn();
			String sql = "update teacher set classroom = ? where teacherId = ?";
			stat = conn.prepareStatement(sql);
			
			stat.setInt(1, teacher.getClassRoom());
			stat.setInt(2, teacher.getTeacherId());
			
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, stat, null);
		}
		
	}
	
	
	public void resetCapacity(Teacher teacher) throws Exception {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = DBUtils.getConn();
			String sql = "update teacher set capacity = 0 where teacherId = ?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, teacher.getTeacherId());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, stat, null);
		}
		
	}
	

	public void updateCapacity(Teacher teacher) throws Exception {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = DBUtils.getConn();
			String sql = "update teacher set capacity = ? where teacherId = ?";
			stat = conn.prepareStatement(sql);
			
			stat.setInt(1, teacher.getCapacity());
			stat.setInt(2, teacher.getTeacherId());
			
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, stat, null);
		}
		
	}
	
	
	public List<Teacher> findAll() throws Exception{
		List<Teacher> teachers = new ArrayList<Teacher>();
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			String sql="select * from Teacher";
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			
			while(rs.next()) {
				
				int teacherId = rs.getInt("teacherId");
				String name = rs.getString("teacherName");
							
				Teacher teacher = new Teacher();
				teacher.setTeacherId(teacherId);
				teacher.setName(name);
				teacher.setCapacity(rs.getInt("capacity"));
				teacher.setGrade(rs.getInt("grade"));
				teacher.setClassRoom(rs.getInt("classRoom"));
				teacher.setMaxCapacity(rs.getInt("maxCapacity"));
				
				teachers.add(teacher);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, stat, rs);
		}
		return teachers;
	}

}
