package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;
import util.DBUtils;

public class AddUserServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 處理表單中文參數值的問題
		request.setCharacterEncoding("utf-8"); //對post有效
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();

		// 讀取用戶信息 如果回傳是null代表打錯或沒有這個東西 如果是""空字符串，代表對方沒打東西
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		

		
		UserDAO dao = new UserDAO();
		// 將用戶信息插入到數據庫
		try {
			/*
			 * 先查看用戶名是否存在，如果已經存在，
			 * 則轉發到addUser.jsp，提示"用戶名
			 * 已經存在";否則，將該用戶的信息插入
			 * 到數據庫，重定向到用戶列表。
			 */
			User user = dao.findByUsername(username);
			if(user != null) {
				request.setAttribute("msg","用戶名已經存在");
				request.getRequestDispatcher("addUser.jsp").forward(request, response);
			}else {
				user = new User();
				user.setUsername(username);
				user.setPwd(pwd);
				user.setEmail(email);
				dao.save(user);
				//重定向到用戶列表
				response.sendRedirect("list");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			out.println("系統繁忙，稍後重試");
		}

		// 輸出用戶信息
		/*
		 * 這行代碼的作用: 
		 * 1. 設置content-type消息頭的值。 
		 * 2. out.println方法在輸出時，會使
		 * 用 charset指定的字符集來編碼。
		 */
		response.setContentType("text/html;charset=utf-8");

	}

}
