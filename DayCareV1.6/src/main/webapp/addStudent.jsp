<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>add student</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<%
	Object obj = session.getAttribute("teacherId");
	if(obj == null){
		response.sendRedirect("login.jsp");
		return;
	}else if((Integer)obj!= 0){
		response.sendRedirect("login.jsp");
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
							<%=sdf.format(date)%> <br />
					</p>
				</div>
				<div id="topheader">
					<h1 id="title">
						<a href="#">DayCare Student Data</a>
					</h1>
				</div>
				<div id="navigation"></div>
			</div>
			<div id="content">
				<p id="whereami"></p>
				<h1>New Student information:</h1>

				<form action="add.do" method="get">
					<table cellpadding="0" cellspacing="0" border="0"
						class="form_table">
						<tr>
							<td valign="middle" align="right">Name</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="name" /></td>
						</tr>
						<tr>
							<td valign="middle" align="right">Age</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="age" value="17"/> </td>
						</tr>
						<tr>
							<td valign="middle" align="right">Parent's Name</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="parentsName"/></td>
						</tr>
						<tr>
							<td valign="middle" align="right">Address</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="address" value="Boston MA"/> </td>
						</tr>
						<tr>
							<td valign="middle" align="right">Phone</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="phone" value="123456789"/></td>
						</tr>

						<tr>
							<td valign="middle" align="right">Enroll Day</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="enrollDay" value="2019-09-01" /></td>
						</tr>

						<tr>
							<td valign="middle" align="right">Enroll Status</td>
							<td valign="middle" align="left">
								
								<input type="radio"
								class="inputgri" name="enrollStatus" value="y" checked="checked"/>
								YES    <input type="radio" class="inputgri" name="enrollStatus"
								value="n"/>NO</td>
	
						</tr>
						
						<tr>
							<td valign="middle" align="right">Dtap6</td>
							<td valign="middle" align="left"><input type="radio"
								class="inputgri" name="dtap6" value="y" />
								YES    <input type="radio" class="inputgri" name="dtap6"
								value="n" checked="checked" />NO</td>
						</tr>
						<tr>
							<td valign="middle" align="right">Hib6</td>
							<td valign="middle" align="left"><input type="radio"
								class="inputgri" name="hib6" value="y"/>
								YES    <input type="radio" class="inputgri" name="hib6"
								value="n" checked="checked"/>NO</td>
						</tr>
						<tr>
							<td valign="middle" align="right">Polio6</td>
							<td valign="middle" align="left"><input type="radio"
								class="inputgri" name="polio6" value="y" />
								YES    <input type="radio" class="inputgri" name="polio6"
								value="n" checked="checked" />NO</td>
						</tr>
						<tr>
							<td valign="middle" align="right">Hepb6</td>
							<td valign="middle" align="left"><input type="radio"
								class="inputgri" name="hepb6" value="y"  />
								YES    <input type="radio" class="inputgri" name="hepb6"
								value="n" checked="checked"/>NO</td>
						</tr>
						<tr>
							<td valign="middle" align="right">Mmr12</td>
							<td valign="middle" align="left"><input type="radio"
								name="mmr12" value="y" checked="checked" />YES      <input
								type="radio" class="inputgri" name="mmr12" value="n" checked="checked" />NO</td>
						</tr>
						<tr>
							<td valign="middle" align="right">Var12</td>
							<td valign="middle" align="left"><input type="radio"
								name="var12" value="y" />YES      <input type="radio" name="var12"
								value="n" checked="checked" />NO
						</tr> 
						<tr>
							<td valign="middle" align="right">Dtap15</td>
							<td valign="middle" align="left"><input type="radio"
								class="inputgri" name="dtap15" value="y" />
								YES    <input type="radio" class="inputgri" name="dtap15"
								value="n" checked="checked" />NO </td>
						</tr>
						
						<tr>
							<td valign="middle" align="right">Polio15</td>
							<td valign="middle" align="left"><input type="radio"
								class="inputgri" name="polio15" value="y"/>
								YES    <input type="radio" class="inputgri" name="polio15"
								value="n" checked="checked" />NO </td>
						</tr>
						
						
					</table>
					<p>
						<input type="button" class="button" value="Back" onclick="{if(confirm('Are you sure to leave?'))location='<%=request.getContextPath()%>/teacherList.do'}"/>
						<input type="submit" class="button" value="Confirm" onclick="return confirm('Do you confirm that all the data are correct?');"/>
					</p>
				</form>
			</div>
		</div>
		<div id="footer">
			<div id="footer_bg">Daniel DayCare Center</div>
		</div>
	</div>
</body>
</body>
</html>