package com.seonhui.app.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;

@Component
public class DBConnectionSample {
	public Connection getConnection() throws Exception {
		String username = "";
		String password = "";

		String url = "jdbc:oracle:thin:@ip:port:SID";

		String driver = "oracle.jdbc.driver.OracleDriver";

		Class.forName(driver);

		Connection con = DriverManager.getConnection(url, username, password);

		return con;
	}
}
