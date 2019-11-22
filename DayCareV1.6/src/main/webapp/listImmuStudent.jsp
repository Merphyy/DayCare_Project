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
						Student Vaccine Infomation
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								Student ID
							</td>
							<td>
								Student Name
							</td>
							<td>
								Student Age
							</td>
							<td>
								Hib6
							</td>
							<td>
								Dtap6
							</td>
							<td>
								Dtap15
							</td>
							<td>
								Polio6
							</td>
							<td>
								Polio15
							</td>
							<td>
								Hepb6
							</td>
							<td>
								Mmr12
							</td>
							<td>
								Var12
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
								<%=student.getHib6()%>
							</td>
							<td>
								<%=student.getDtap6()%>
							</td>
							<td>
								<%=student.getDtap15()%>
							</td>
							<td>
								<%=student.getPolio6()%>
							</td>
							<td>
								<%=student.getPolio15()%>
							</td>
							<td>
								<%=student.getHepb6()%>
							</td>
							<td>
								<%=student.getMmr12()%>
							</td>
							<td>
								<%=student.getVar12()%>
							</td>
						</tr>
								<%
							}
						%>
					
					</table>
					<p>
						<%Integer teacherId = (Integer)request.getAttribute("teacherId"); %>
						<input type="button" class="button" value="Back" onclick="location='<%=request.getContextPath()%>/studentList.do?teacherId=<%=teacherId%>'"/>
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
