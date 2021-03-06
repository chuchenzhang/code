package com.test.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class JdbcDemo1 {
    public static void main(String[] args) throws Exception
    {
        //1.导入驱动jar包
        //2.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //3.获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/xinkongapp","root","root");
        //4.定义sql语句
        String sql = "select * from students limit 5";
        //5.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        //6.执行sql
        ResultSet res = stmt.executeQuery(sql);
        while(res.next()){
            System.out.println(res.getString("name"));
        }
        //7.处理结果
//		System.out.println(count);
        //8.释放资源
        stmt.close();
        conn.close();

    }
}
