package entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import dao.ClassDAO;
import dao.TeacherDAO;

public class Class {
	private int classId;
	private int C_capacity;
	private int C_maxCapacity;
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getC_capacity() {
		return C_capacity;
	}
	public void setC_capacity(int c_capacity) {
		C_capacity = c_capacity;
	}
	public int getC_maxCapacity() {
		return C_maxCapacity;
	}
	public void setC_maxCapacity(int c_maxCapacity) {
		C_maxCapacity = c_maxCapacity;
	}
	@Override
	public String toString() {
		return "Class [classId=" + classId + ", C_capacity=" + C_capacity + ", C_maxCapacity=" + C_maxCapacity + "]";
	}
	
	public static void resetAssignClassRoom() throws Exception {
		TeacherDAO tDao = new TeacherDAO();
		List<Teacher> teachers = tDao.findAll();
		for (Teacher t : teachers) {
			tDao.resetClassRoom(t);
		}
		ClassDAO cDao = new ClassDAO();
		List<entity.Class> cla = cDao.findAll();
		for (entity.Class c : cla) {
			cDao.resetCapacity(c);
		}
		
	}
	
	
	public static List<Class> assignClass() throws Exception{
		  ClassDAO classDao = new ClassDAO();
		  TeacherDAO teaDao = new TeacherDAO();
		  List<Class> cla = new LinkedList<Class>();
		  List<Teacher> tea = new LinkedList<Teacher>();
		  cla = classDao.findAll();
		  tea = teaDao.findAll();
		   
		  for (Class c: cla) {
		   int capacity = c.getC_capacity();
		   int maxCapacity = c.getC_maxCapacity();
		   for (Teacher teacher : tea) {
		    int grade = teacher.getGrade();
		    //此班放不下老师了
		    if(capacity == c.getC_maxCapacity()) {
		     break;
		    }
		    //提前判断老师的吃classId是否为0，如果不为0，则跳出当前循环，检测下一个学生
		    if(teacher.getClassRoom() != 0) {
		     continue;
		    }
		    //判断学生年龄，和应该分配的grade，已经老师的capacity
		    if(grade == 1 && capacity < maxCapacity && (c.getClassId()==1 || c.getClassId()==2)) {
		     c.setC_capacity(++capacity);
		     teacher.setClassRoom(c.getClassId());
		    }else if(grade == 2 && capacity < maxCapacity && (c.getClassId()==3 || c.getClassId()==4)) {
		     c.setC_capacity(++capacity);
		     teacher.setClassRoom(c.getClassId());
		    }else if(grade == 3 && capacity < maxCapacity && (c.getClassId()==5 || c.getClassId()==6)) {
		     c.setC_capacity(++capacity);
		     teacher.setClassRoom(c.getClassId());
		    }else if(grade == 4 && capacity < maxCapacity && c.getClassId() == 7) {
		     c.setC_capacity(++capacity);
		     teacher.setClassRoom(c.getClassId());
		    }else if(grade == 5 && capacity < maxCapacity && c.getClassId() == 8) {
		     c.setC_capacity(++capacity);
		     teacher.setClassRoom(c.getClassId());
		    }else if(grade == 6 && capacity < maxCapacity && c.getClassId() == 9) {
		     c.setC_capacity(++capacity);
		     teacher.setClassRoom(c.getClassId());
		    }
		   }
		  }
		  
		//save teacher data
			for(Teacher t : tea) {
				teaDao.updateClassRoom(t);
			}
			//save class data
			for(entity.Class x : cla) {
				System.out.println(x);
				classDao.updateCapacity(x);
			}
		  return cla;
		 }
	
	
	
	
	
}
