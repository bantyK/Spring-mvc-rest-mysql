package com.example.database;

import com.example.model.Student;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Banty on 18/04/17.
 */
public class StudentDAO {

    private final DataSource dataSource;

    public StudentDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public void addStudent(Student student) {
        Assert.notNull(student);

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO Student (id,name,age,mobile,dob,stream) VALUES (?,?,?,?,?,?)");

            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getMobile());
            preparedStatement.setString(5, student.getDob().toString());
            preparedStatement.setString(6, student.getStream());

            preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student retrieveStudent(int id) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT name,age,mobile,dob,stream FROM Student WHERE id = ?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(!resultSet.first()){
                return null;
            }
            Student student = new Student(
                    id,
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getString(4),
                    resultSet.getDate(5),
                    resultSet.getString(6)
            );
            connection.close();
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
