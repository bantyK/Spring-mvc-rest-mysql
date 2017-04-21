package com.example.database;

import com.example.model.Student;
import org.springframework.util.Assert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Banty on 18/04/17.
 */
public class StudentDAO {


    private final Connection connection;

    public StudentDAO(Connection connection) {
        this.connection = connection;
    }


    public void addStudent(Student student) {
        Assert.notNull(student);

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO Student (id,name,age,mobile,dob,stream) VALUES (?,?,?,?,?,?)");

            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getMobile());
            preparedStatement.setDate(5, student.getDob());
            preparedStatement.setString(6, student.getStream());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student retrieveStudent(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT name,age,mobile,dob,stream FROM Student WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.first()) {
                return null;
            }
            Student student = new Student();
            student.setId(id);
            student.setName(resultSet.getString("name"));
            student.setAge(resultSet.getInt("age"));
            student.setMobile(resultSet.getString("mobile"));
            student.setDob(resultSet.getDate("dob"));
            student.setStream(resultSet.getString("stream"));

            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> studentList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM  Student");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getInt(3));
                student.setMobile(resultSet.getString(4));
                student.setDob(resultSet.getDate(5));
                student.setStream(resultSet.getString(6));
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    public boolean updateStudent(int id, Student newStudent) {
        Student studentToUpdate = retrieveStudent(id);
        String sqlUpdateStatement = null;
        if (studentToUpdate != null) {
            sqlUpdateStatement = "UPDATE Student SET ";
            if (newStudent.getId() != 0) {
                sqlUpdateStatement += " id = " + newStudent.getId();
            }
            if (newStudent.getAge() != 0) {
                sqlUpdateStatement += ", age = " + newStudent.getAge();
            }
            if (newStudent.getName() != null) {
                sqlUpdateStatement += ", name = \"" + newStudent.getName() + "\"";
            }
            if (newStudent.getDob() != null) {
                sqlUpdateStatement += ", dob = \"" + newStudent.getDob() + "\"";
            }
            if (newStudent.getMobile() != null) {
                sqlUpdateStatement += ", mobile = \"" + newStudent.getMobile() + "\"";
            }
            if (newStudent.getStream() != null) {
                sqlUpdateStatement += ", stream = \"" + newStudent.getStream() + "\"";
            }
            sqlUpdateStatement += " WHERE id = " + id;
            sqlUpdateStatement += ";";

            System.out.println("update query = " + sqlUpdateStatement);

            try {
                PreparedStatement statement = connection.prepareStatement(sqlUpdateStatement);
                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        } else {
            return false;
        }
    }

    public int getTotalNumberOfStudent() {
        return getAllStudents().size();
    }

    public boolean deleteStudent(int id) {
        Student studentToDelete = retrieveStudent(id);
        if (studentToDelete != null) {
            String sqlStatement = "DELETE FROM Student WHERE id = " + id;
            try {
                PreparedStatement statement = connection.prepareStatement(sqlStatement);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }


}
