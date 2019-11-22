package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

//數據庫工具類
public class DBUtils {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	private static BasicDataSource dataSource;

	// 只在一開使執行一次
	static {
		// 創建讀取配置文件的屬性對象
		Properties prop = new Properties();
		// 獲取文件輸入流
		InputStream ips = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		// 把文件加載到屬性對象中
		try {
			prop.load(ips);
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			
			// 創建數據源對象
			dataSource = new BasicDataSource();
			// 創建數據庫連接信息
			dataSource.setDriverClassName(driver);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			// 設置初始連接數量
			dataSource.setInitialSize(3);
			// 設置最大連接數量
			dataSource.setMaxActive(3);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {// 關閉流
			try {
				ips.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// 獲取連接
	public static Connection getConn() throws Exception {

//		Class.forName(driver);
//		Connection conn = DriverManager.getConnection(url, username, password);

		// 從連接池中獲取連接
		return dataSource.getConnection();
	}

	// 關閉資源
	public static void close(Connection conn, Statement stat, ResultSet rs) {
		try {
			// 判斷有值時關閉
			if (rs != null) {
				rs.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			// 判斷有值時關閉
			if (stat != null) {
				stat.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			// 判斷有值時關閉
			if (conn != null) {
				//打開自動提交
				conn.setAutoCommit(true);
				conn.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
