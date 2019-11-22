package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Student;
import entity.User;
import util.DBUtils;

public class StudentDAO {
	
	
	public void resetTeacherId(Student student) throws Exception {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = DBUtils.getConn();
			String sql = "update student set teacherId = 0 where studentId = ?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, student.getStudentId());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, stat, null);
		}
		
	}
	
	public void updateTeacherId(Student student) throws Exception {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = DBUtils.getConn();
			String sql = "update student set teacherId = ? where studentId = ?";
			stat = conn.prepareStatement(sql);
			
			stat.setInt(1, student.getTeacherId());
			stat.setInt(2, student.getStudentId());

			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, stat, null);
		}
		
	}
	
	
	
	public void save(Student student) throws Exception {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn = DBUtils.getConn();
			String sql = "insert into student values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, student.getName());
			stat.setInt(2, student.getAge());
			stat.setString(3, student.getParentsName());
			stat.setString(4, student.getAddress());
			stat.setString(5, student.getPhone());
			stat.setInt(6, student.getTeacherId());
			stat.setString(7, student.getEnrollDay());
			stat.setString(8, student.getHib6());
			stat.setString(9, student.getDtap6());
			stat.setString(10, student.getDtap15());
			stat.setString(11, student.getPolio6());
			stat.setString(12, student.getPolio15());
			stat.setString(13, student.getHepb6());
			stat.setString(14, student.getMmr12());
			stat.setString(15, student.getVar12());
			stat.setString(16, student.getNextEnrollDay());
			stat.setString(17, student.getEnrollStatus());

			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, stat, null);
		}
		
	}
	public List<Student> findAll() throws Exception{	
		List<Student> Students = new ArrayList<Student>();
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			String sql="select * from Student";
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			while(rs.next()) {
				
				int studentId = rs.getInt("studentId");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String parentsName = rs.getString("parentsName");
				String address = rs.getString("address");
				String phone= rs.getString("phone");
				int teacherId= rs.getInt("teacherId");
				String enrollDay= rs.getString("enrollDay");
				String hib6= rs.getString("Hib6");
				
				Student student = new Student();
				
				student.setStudentId(studentId);
				student.setName(name);
				student.setAge(age);
				student.setParentsName(parentsName);
				student.setAddress(address);
				student.setPhone(phone);
				student.setTeacherId(teacherId);
				student.setEnrollDay(enrollDay);
				
				student.setEnrollStatus(rs.getString("enrollStatus"));
				student.setNextEnrollDay(rs.getString("nextenrollDay"));
				
				student.setHib6(hib6);		
				student.setDtap6(rs.getString("Dtap6"));
				student.setDtap15(rs.getString("Dtap15"));
				student.setPolio6(rs.getString("Polio6"));
				student.setPolio15(rs.getString("Polio15"));
				student.setHepb6(rs.getString("Hepb6"));
				student.setMmr12(rs.getString("Mmr12"));
				student.setVar12(rs.getString("Var12"));
				
				Students.add(student);

				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, stat, rs);
		}
		return Students;
	}

}
