package com.mx.util;

import java.sql.*;

/**
 * @author MX
 */
public class JdbcUtil {
    private String url="jdbc:mysql://localhost:3306/employers?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
    private String username="root";
    private String password="";

    /**
     * 创建Connection数据库唯一连接对象connection
     * 创建PreparedStatement preparedStatement对象，用于执行sql语句
     * */
    Connection connection=null;
    PreparedStatement preparedStatement=null;

    /**
     * Class.forName(driver)注册数据库驱动程序到内存当中
     * */
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库唯一连接对象connection,获取数据库地址url
     * 获取连接用户名和密码
     * @return connection
     * */
    public Connection getConnection(){
        try {
            connection= DriverManager.getConnection(url,username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    /**
    * 获取PreparedStatement对象执行sql语句
     * PreparedStatement对象比Statement对象更为安全，可以防止sql注入
     * @return preparedStatement
    * */
    public PreparedStatement getPreparedStatement(String sql) {
        try {
            preparedStatement=getConnection().prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return preparedStatement;
    }

    /**
    * 创建数据库连接关闭方法
     * 判断connection对象与preparedStatement对象是否为空
     * 如为空，则关闭两个对象与数据库的连接
    * */
    public void Close(){
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 关闭ResultSet结果集对象连接
     * */
    public void Close(ResultSet resultSet){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        this.Close();
    }

}
