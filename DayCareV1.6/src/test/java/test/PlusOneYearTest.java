package test;

import java.text.ParseException;

import org.junit.Test;

import entity.Student;

public class PlusOneYearTest {
	
	@Test
	public void test() throws ParseException {
		
		System.out.println(Student.plusOneYear("a"));
	}

}
