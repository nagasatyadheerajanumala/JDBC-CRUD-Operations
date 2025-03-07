package com.student.manage;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class StudentDAO {
    public static boolean insertStudentToDB(Student student){
        //jdbc code
        boolean flag = false;
        try {
            System.out.println("database pushing");
            Connection con = CP.createConnection();
            String q = "INSERT INTO student (first_name, last_name, email, gender, phone_number, address, enrollment_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getGender());
            ps.setString(5, student.getPhoneNumber());
            ps.setString(6, student.getAddress());
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            ps.setTimestamp(7, timestamp);

            ps.executeUpdate();
            flag = true;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return flag;

    }

    public static boolean deleteStudent(int id){
        boolean flag = false;
        try {
            Connection con = CP.createConnection();
            String q = "DELETE FROM student WHERE student_id = ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, id);
            ps.executeUpdate();
            flag = true;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return flag;
    }


    public static boolean displayStudent(int id){
        boolean flag = false;
        try {
            Connection con = CP.createConnection();
            String q = "SELECT * FROM student WHERE student_id = ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, id);
            ResultSet set = ps.executeQuery();
            while(set.next()){
                System.out.println(set.getString("first_name"));
                System.out.println(set.getString("last_name"));
                System.out.println(set.getString("email"));
                System.out.println(set.getString("gender"));
                System.out.println(set.getString("phone_number"));
                System.out.println(set.getString("address"));
                System.out.println(set.getString("enrollment_date"));
                System.out.println("Successfully fetched data");
            }
            flag = true;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return flag;

    }
}
