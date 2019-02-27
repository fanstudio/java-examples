package com.fanstudio.demo;

import java.sql.*;

/**
 * @author Admin
 * @date 2019/2/27
 * @description
 */
public class JDBCDemo {
    public static void main(String[] args) {
        System.out.println("enter");

        Connection connection = null;
        Statement statement = null;
        try {
            // 加载驱动，其实这一步我在测试时，发现不需要也会加载mysql，我觉得应该是下面的getConnection时，里面有隐含的操作
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/data_flow_db", "root", "123456");
            statement = connection.createStatement();

            // 执行查询
            ResultSet resultSet = statement.executeQuery("select * from t_device_info");
            while (resultSet.next()) {
                String serviceName = resultSet.getString("service_name");
                String ipAddress = resultSet.getString("ip_address");
                System.out.println(serviceName + ":" + ipAddress);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
