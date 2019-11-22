<%@page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="entity.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>DayCare Student Data</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
	<%
	//進行session驗證。
	Object obj = session.getAttribute("teacherId");
	if(obj == null){
		//沒有登入，重定向到登入頁面
		response.sendRedirect("login.jsp");
		//沒有必須向下執行
		return;
	}
	%>
	<%Integer teacherId = (Integer)request.getAttribute("teacherId"); %>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
						<%	
							Date date = new Date();
							SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy"); 
							%>
							<%=sdf.format(date)%>
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">DayCare Student Data</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Student List
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								<a href="studentList.do?teacherId=<%=teacherId%>">Student ID</a>
								
							</td>
							<td>
								Name
							</td>
							<td>
								<a href="sortAge.do?teacherId=<%=teacherId%>">Age</a>
							</td>
							<td>
								Parent's Name
							</td>
							<td>
								Address
							</td>
							<td>
								Phone Number
							</td>
							<td>
								Teacher ID
							</td>
							<td>
								Enrollment Day
							</td>
							
						</tr>
						<%
							List<Student> students = (List<Student>) request.getAttribute("students");
							for(int i=0;i<students.size();i++){
								Student student = students.get(i);
								%>
						<tr class="row<%=i % 2 + 1%>">
							<td>
								<%=student.getStudentId()%>
							</td>
							<td>
								<%=student.getName()%>
							</td>
							<td>
								<%=student.getAge()%>
							</td>
							<td>
								<%=student.getParentsName()%>
							</td>
							<td>
								<%=student.getAddress()%>
							</td>
							<td>
								<%=student.getPhone()%>
							</td>
							<td>
								<%=student.getTeacherId()%>
							</td>
							<td>
								<%=student.getEnrollDay()%>
							</td>
							
						</tr>
								<%
							}
						%>
					
					</table>
					<p>
						
						<input type="button" class="button" value="Back" onclick="location='<%=request.getContextPath()%>/teacherList.do'"/>
						<input style="color:red;" type="button" class="button" value="Student didn't get Vaccine" onclick="location='<%=request.getContextPath()%>/immuStudentNotYetList.do?teacherId=<%=teacherId%>'"/>
						<input type="button" class="button" value="Student Vaccine Infomation" onclick="location='<%=request.getContextPath()%>/immuStudentList.do?teacherId=<%=teacherId%>'"/>
						<input type="button" class="button" value="Assign Teacher" onclick="location='<%=request.getContextPath()%>/assignTeacher.do'"/>
						<input type="button" class="button" value="Reset Teacher" onclick="location='<%=request.getContextPath()%>/resetTeacherId.do'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				Daniel DayCare Center
				</div>
			</div>
		</div>
	</body>
</html>
