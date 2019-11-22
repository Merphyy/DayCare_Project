package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;
import util.DBUtils;

public class ListUserServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 處理表單中文參數值的問題
		request.setCharacterEncoding("utf-8"); //對post有效
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//查詢出所有用戶的信息
		UserDAO dao = new UserDAO();
		try {
			List<User> users = dao.findAll();
			//依據查詢到的用戶信息，輸出表格
			/*
			 * 因為Servlet不擅長處理複雜的頁面，
			 * 所以，我們使用轉發機制，將數據
			 * 綁定到request對象上，然後轉發給
			 * jsp來展現。
			 */
			//step1. 將數據綁定到request對象上
			request.setAttribute("users", users);
			//step2. 獲取轉發器
			RequestDispatcher rd = request.getRequestDispatcher("listUser.jsp");
			//step3. 轉發
			rd.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("系統繁忙，稍後重試");
		}
	}
	

}
