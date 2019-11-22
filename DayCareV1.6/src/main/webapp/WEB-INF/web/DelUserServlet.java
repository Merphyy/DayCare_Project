package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

public class DelUserServlet extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//讀取要刪除的用戶id
		int id = Integer.parseInt(request.getParameter("id")); 
		
		//從數據庫中刪除指定id用戶
		UserDAO dao = new UserDAO();
		try {
			dao.delete(id);	
			//重定向到用戶列表
			response.sendRedirect("list");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("稍後重試");
		}
		
	}
	

}
