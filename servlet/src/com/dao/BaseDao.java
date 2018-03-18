package com.dao;

import java.sql.*;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.jdbc.Statement;

import javax.naming.*;

public class BaseDao {
	DataSource dataSource;
	// 数据库链接对象
	private java.sql.Connection conn;
	// 数据库命令执行对象
	private PreparedStatement pstmt;
	// 数据库返回结果
	private java.sql.ResultSet rs;

	// 在构造方法中返回数据源对象
	public BaseDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context
					.lookup("java:comp/env/jdbc/fivecrowdsourcing");
		} catch (NamingException ne) {
			System.out.println("Exception:" + ne);
		}
	}

	// 返回一个连接对象
	public Connection getConnection() throws Exception {
		conn=dataSource.getConnection();
		return conn;
	}

	// 以下是为了商户审查增加的方法
	public java.sql.ResultSet executeQuery(String query, List<String> params) {
		
		try {
			getConnection();
			// 3、创建命令执行对象
			pstmt = conn.prepareStatement(query);
			// 4、执行
			if (params != null && params.size() > 0) {
				for (int i = 0; i < params.size(); i++) {
					pstmt.setString(i + 1, params.get(i));
				}
			}
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	// 执行写操作方法
	public int executeUpdate(String query, List<String> params) {
		int result = 0;
		
		try {
			getConnection();
			// 3、创建命令执行对象
			pstmt = conn.prepareStatement(query);
			// 4、执行
			if (params != null && params.size() > 0) {
				for (int i = 0; i < params.size(); i++) {
					pstmt.setString(i + 1, params.get(i));
				}
			}
			// 5、处理结果
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6、释放资源
			this.close();
		}
		return result;
	}

	// 关闭资源
	public void close() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
