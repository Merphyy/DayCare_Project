package test;

import dao.StudentDAO;
import entity.Student;

public class UpdateStudentTIdTest {
	public static void main(String[] args) throws Exception {
		Student student = new Student();
		student.setStudentId(16);
		student.setTeacherId(-1);
		
		StudentDAO dao = new StudentDAO();
		dao.updateTeacherId(student);
		
		System.out.println("Success");
		
	}

}
