package com.student.manage;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class CP {
    static Connection con;
    public static Connection createConnection(){
        //load the driver
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            String username = "root";
//            String password = "root";
//            String url = "jdbc:mysql://localhost:3306/Student_manage?useSSL=false&allowPublicKeyRetrieval=true";
//            //create the connection
//            con = (Connection) DriverManager.getConnection(url, username, password);

            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost:3306/Student_manage?useSSL=false&allowPublicKeyRetrieval=true";
            con = DriverManager.getConnection(url, user, password);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

}
