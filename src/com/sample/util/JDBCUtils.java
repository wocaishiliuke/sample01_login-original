package com.sample.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * JDBC工具类
 */
public class JDBCUtils {

	static ComboPooledDataSource cpds = new ComboPooledDataSource();

	/**
	 * 获取连接
	 * 
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		return cpds.getConnection();
	}

	/**
	 * 释放资源
	 */
	public static void release(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		release(conn, stmt);
	}

	public static void release(Connection conn, Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
