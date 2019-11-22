package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import entity.Student;

public class Service {
	public static void processRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8"); // 對post有效
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Integer studentId = 0;
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String parentsName = request.getParameter("parentsName");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		Integer teacherId = 0;
		String enrollDay = request.getParameter("enrollDay");
		String nextEnrollDay = request.getParameter("nextEnrollDay");
		String enrollStatus = request.getParameter("enrollStatus");
		String hib6 = request.getParameter("hib6");
		String dtap6 = request.getParameter("dtap6");
		String dtap15 = request.getParameter("dtap15");
		String polio6 = request.getParameter("polio6");
		String polio15 = request.getParameter("polio15");
		String hepb6 = request.getParameter("hepb6");
		String mmr12 = request.getParameter("mmr12");
		String var12 = request.getParameter("var12");

		Student newStudent = null;
		try {
			newStudent = new Student(studentId, name, age, parentsName, address, phone, teacherId, enrollDay,
					nextEnrollDay, enrollStatus, hib6, dtap6, dtap15, polio6, polio15, hepb6, mmr12, var12);

			StudentDAO dao = new StudentDAO();
			try {
				dao.save(newStudent);
				
			} catch (Exception e) {
				e.printStackTrace();
				out.println("We ecounter some problems! Please try again and check all foramt are correct! ");
			}
		} catch (ParseException e) {
			e.printStackTrace();
			out.println("We ecounter some problems! Please try again!");
		}
		response.sendRedirect("studentList.do?teacherId=0");

	}

}
