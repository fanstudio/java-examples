package com.fanstudio.demo;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Admin
 * @date 2019/2/27
 * @description
 */
public class DataSourceDemo {
    public static void main(String[] args) {
        // 创建连接池
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/data_flow_db");
        config.setUsername("root");
        config.setPassword("123456");

        DataSource dataSource = new HikariDataSource(config);
        Connection connection = null;
        Statement statement = null;
        try {
            // 通过数据库连接池获取连接
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // 执行查询
            ResultSet resultSet = statement.executeQuery("select * from t_device_info");
            while (resultSet.next()) {
                String serviceName = resultSet.getString("service_name");
                String ipAddress = resultSet.getString("ip_address");
                System.out.println(serviceName + ":" + ipAddress);
            }
        } catch (SQLException e) {
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

        ((HikariDataSource) dataSource).close();

    }
}
