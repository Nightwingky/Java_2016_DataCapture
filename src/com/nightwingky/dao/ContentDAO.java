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

    public void addStudent(ContentVO contentVO) {
        Connection conn = getConnection();

        try {
            String sql = "INSERT INTO tb_course_info(newsIconUrl, newsTitle, newsContent) " +
                    "values (?, ?, ?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, contentVO.getNewsIconUrl());
            preparedStatement.setString(2, contentVO.getNewsTitle());
            preparedStatement.setString(3, contentVO.getNewsContent());

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

        //创建要放入StudentVO对象的List
        List<ContentVO> ls = new ArrayList<ContentVO>();
        //创建一个StudenVO类型的变量
        //注意！！！！！这里先不将它实例化(实例化指StudentVO studentVO = new StudentVO())
        ContentVO contentVO = null;

        /*
         * try{}中的语句可能会有异常，所以用try包裹，
         * 如果出现异常，把它catch出来并打印异常信息
         * 最后(finally语句块)关闭数据库连接
         */
        try {
            String sql = "SELECT * FROM tb_course_info";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //查询后直接返回的结果是一个ResultSet对象，所以创建一个ResultSet对象保存查询结果
            ResultSet resultSet = preparedStatement.executeQuery(sql);

            //将ResultSet对象中的每一条记录转化成StudentVO对象，并将该StudentVO加入到List中
            //resultSet.next()每被调用一次，指针向下指一行，直到没有为止
            while (resultSet.next()) {
                /*
                 * 在这里将前面创建的StudentVO类型的变量实例化，
                 * 并通过resultSet.get***()方法取出每一条记录里面对应的每一个值，
                 * 然后传入StudentVO的构造函数
                 */
                contentVO = new ContentVO(
                        resultSet.getString("newsIconUrl"),
                        resultSet.getString("newsTitle"),
                        resultSet.getString("newsContent"));
                //将创建好的StudentVO对象加入到List中
                ls.add(contentVO);
            }

            return ls;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭数据库连接
            closeConnection(conn);
        }

        return null;
    }
}
