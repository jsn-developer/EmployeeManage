package jp.co.solxyz.lessons.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDao {

	// 接続文字列
	private static final String url = "jdbc:mysql://localhost:3306/empdb?useSSL=false";
	// ユーザーIDとパスワード
	private static final String user = "root";
	private static final String password = "root";

	protected Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");

		return DriverManager.getConnection(url, user, password);
	}
}
