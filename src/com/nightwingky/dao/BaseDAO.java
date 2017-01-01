package com.nightwingky.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by nightwingky on 17-1-1.
 */
public class BaseDAO {

    protected Connection getConnection() {
        Connection conn = null;
        try {
            //1. 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2. 获取到指定数据库的连接对象
            String url = "jdbc:mysql://127.0.0.1:3306/db_java_shopping_cart";
            conn = DriverManager.getConnection(url, "nightwingky", "666796");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    //关闭数据库连接的方法
    protected void closeConnection(Connection conn) {
        if(conn == null)
            return;
        try {
            conn.close();//关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
