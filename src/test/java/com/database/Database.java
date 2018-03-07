package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	public Connection conn;
	public Statement stmt;

	public Statement getStatements() throws SQLException, ClassNotFoundException {
		// For credentials
		Class.forName("com.mysql.jdbc.Driver");
		String userName = "rajesh.n";
		String passWord = "ra&95$sHe2N5";

		// connection driver
		conn = DriverManager.getConnection("jdbc:mysql://10.125.3.20:3306/izmoweb_r1v2", userName, passWord);
		stmt = conn.createStatement();
		return stmt;
	}

	public ResultSet getData(String query) throws SQLException, ClassNotFoundException {
		ResultSet data = getStatements().executeQuery(query);
		return data;
	}

}
