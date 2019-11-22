package test;

import java.util.List;

import dao.TeacherDAO;
import entity.Teacher;

public class TeacherDAOTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		TeacherDAO dao = new TeacherDAO();
		List<Teacher> list = dao.findAll();
		
		for (Teacher t : list) {
			System.out.println(t);
		}

	}

}
