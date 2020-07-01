package com.example.springboottest.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Description:
 * @Author: zyl
 * @CreateDate: 2019/10/18
 */
public class JdbcUtils {





    public static Connection getConnection(String url, String userName, String password) throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }

    // 关闭资源
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 重载关闭方法close(Connection conn, Statement stmt)
    public static void close(Connection conn, Statement stmt) {
        close(conn, stmt, null);
    }
}
