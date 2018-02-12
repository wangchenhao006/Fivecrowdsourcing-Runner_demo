package runnerServlet;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    public static final String TABLE_ACCOUNT = "tb_account";  
    public static final String TABLE_PRODUCT = "tb_product";  
    
	private static Connection mConnection;

    /**
     * 获取数据库连接
     * 
     * @return 唯一数据库连接
     */
    static Connection getConnection() {
        if (mConnection == null) {
            String url = "jdbc:mysql://localhost:3306/fivecrowdsourcing?useSSL=false"; // 数据库的Url
            try {
                Class.forName("com.mysql.jdbc.Driver"); // java反射，固定写法
                mConnection = (Connection) DriverManager.getConnection(url, "root", "root");
                //LogUtil.log("创建数据库连接");
                System.out.println("创建数据库连接");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
        }
        return mConnection;
    }

    /**
     * 查询操作
     * 
     * @param querySql
     *            查询操作SQL语句
     * @return 查询
     * @throws SQLException
     */
    public static ResultSet query(String querySql) throws SQLException {
        Statement stateMent = (Statement) getConnection().createStatement();
        return stateMent.executeQuery(querySql);
    }

    /**
     * 插入、更新、删除操作
     * 
     * @param insertSql
     *            插入操作的SQL语句
     * @return
     * @throws SQLException
     */
    public static int update(String insertSql) throws SQLException {
        Statement stateMent = (Statement) getConnection().createStatement();
        return stateMent.executeUpdate(insertSql);
    }

    /**
     * 关闭数据库连接
     */
    public static void closeConnection() {
        if (mConnection != null) {
            try {
                mConnection.close();
                mConnection = null;
            } catch (SQLException e) {
            	System.out.println("数据库关闭异常：[" + e.getErrorCode() + "]" + e.getMessage());
            	//LogUtil.log("数据库关闭异常：[" + e.getErrorCode() + "]" + e.getMessage());
            }
        }
    }
}

