package com.yuchen.Utils;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 获取连接
 * @author yuchen
 *
 */
public class JDBCUtils {
	// 获取数据源
	public static DataSource dataSource = new ComboPooledDataSource();
	public static Connection getConnection(){
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			System.err.println("获取连接失败");
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void releaseConnection(Connection connent){
		if (connent != null) {
			try {
				connent.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
