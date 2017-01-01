package com.nightwingky.dao;

import com.nightwingky.vo.ContentVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nightwingky on 16-12-30.
 */
public class ContentDAO {
    private Connection getConnection() {
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
    private void closeConnection(Connection conn) {
        if(conn == null)
            return;
        try {
            conn.close();//关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addContent(ContentVO contentVO) {
        Connection conn = getConnection();

        try {
            String sql = "INSERT INTO tb_shoppingcart_info(commodityImageURL, commodityTitle, commodityPrice) " +
                    "values (?, ?, ?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, contentVO.getContentImageURL());
            preparedStatement.setString(2, contentVO.getContentTitle());
            preparedStatement.setString(3, contentVO.getContentPrice());

            int count = preparedStatement.executeUpdate();
            if(count > 0) {
                System.out.println("Insert success!");
            } else {
                System.out.println("Insert failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn);
        }
    }

    public List<ContentVO> quertAll() {

        Connection conn = getConnection();

        List<ContentVO> ls = new ArrayList<ContentVO>();
        ContentVO contentVO = null;

        try {
            String sql = "SELECT * FROM tb_course_info";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            while (resultSet.next()) {
                contentVO = new ContentVO(
                        resultSet.getString("contentImageURL"),
                        resultSet.getString("contentTitle"),
                        resultSet.getString("contentPrice"));
                ls.add(contentVO);
            }

            return ls;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn);
        }

        return null;
    }

    public void updateAllNewsTitle(String updateString, int i) throws SQLException {
        Connection conn = getConnection();

        String sql = "Update tb_course_info SET contentTitle = ? WHERE id = ?";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, updateString);
        preparedStatement.setInt(2, i);

        preparedStatement.execute();
    }

    public void updateAllNewsContent(String updateString, int i) throws SQLException {
        Connection conn = getConnection();

        String sql = "Update tb_course_info SET contentPrice = ? WHERE id = ?";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, updateString);
        preparedStatement.setInt(2, i);

        preparedStatement.execute();
    }
}
