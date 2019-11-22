package entity;

import java.util.LinkedList;
import java.util.List;

import dao.ClassDAO;
import dao.TeacherDAO;

public class Teacher {
	private int teacherId;
	private String name;
	private int capacity;
	private int grade;
	private int classRoom;
	private int maxCapacity;
	
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}
	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", name=" + name + ", capacity=" + capacity + ", grade=" + grade
				+ ", classRoom=" + classRoom + ", maxCapacity=" + maxCapacity + "]";
	}
	
	public static List<Teacher> assignTea() throws Exception{
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
				classDao.updateCapacity(x);
			}
  
		  return tea;
		 }
	
	public static void main(String[] args) throws Exception {
		  Teacher tea = new Teacher();
		  List<Teacher> ta = assignTea();
		  for (Teacher t : ta) {
		   System.out.println(t);
		  }
		  TeacherDAO teaDao = new TeacherDAO();
		 }


}
