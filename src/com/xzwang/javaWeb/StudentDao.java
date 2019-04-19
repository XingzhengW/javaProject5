package com.xzwang.javaWeb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Xingzheng Wang
 * @Date: 4/18/2019 1:35 PM
 * @Description: com.xzwang.javaWeb
 * @Version: 1.0
 */
public class StudentDao {

    public void deleteByFlowId(Integer flowId){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String driverClass = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
            String user = "root";
            String password = "Wxz@1995";

            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, user, password);

            String sql = "DELETE FROM examstudents WHERE flow_id = ?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, flowId);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{

            try {
                if(preparedStatement != null){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String driverClass = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
            String username = "root";
            String password = "Wxz@1995";
            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, username, password);

            String sql = "SELECT flow_id,Type,id_card,exam_card,student_name,location,grade FROM examstudents";

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int flowId = resultSet.getInt(1);
                int type = resultSet.getInt(2);
                String idCard = resultSet.getString(3);
                String examCard = resultSet.getString(4);
                String studentName = resultSet.getString(5);
                String location = resultSet.getString(6);
                int grade = resultSet.getInt(7);

                Student student = new Student(flowId, type, idCard, examCard, studentName, location, grade);
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return students;
    }
}
