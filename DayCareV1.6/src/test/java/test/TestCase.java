package test;

import java.util.List;

import org.junit.Test;

import dao.UserDAO;
import entity.User;

public class TestCase {
	
	@Test
	public void test01() throws Exception {
		UserDAO dao = new UserDAO();
		List<User> users = dao.findAll();
		System.out.println(users);
	}
	
	@Test
	public void test02() throws Exception {
		UserDAO dao = new UserDAO();
		System.out.println(dao.login("root", "root"));
	}
	
	public static void main(String[] args) throws Exception {	
		//System.out.println(DBUtils.getConn());
		UserDAO dao = new UserDAO();
		List<User> users = dao.findAll();
		System.out.println(users);
//		User user = new User();
//		user.setUsername("Maki Kono");
//		user.setPwd("test");
//		user.setEmail("makikono@gmail.com");
//		dao.save(user);
		
		
		
	}

}
