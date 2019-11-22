package test;

import dao.TeacherDAO;
import entity.Teacher;

public class UpdateTeacherCapacityTest {
	public static void main(String[] args) throws Exception {
		TeacherDAO dao = new TeacherDAO();
		
		Teacher t = new Teacher();
		t.setTeacherId(19);
		t.setCapacity(0);
		
		dao.updateCapacity(t);
		
		System.out.println("Success");
	}

}
