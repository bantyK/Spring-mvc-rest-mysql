package com.example.database;

import com.example.model.Student;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;

import static org.junit.Assert.assertEquals;

/**
 * Created by Banty on 19/04/17.
 */
public class StudentDAOTest {
    private StudentDAO studentDAO;
    private Connection connection;
    private Student student;

    @Before
    public void setUp() throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banty", "root", "password");
        studentDAO = new StudentDAO(connection);
        student = new Student();
        student.setId(101);
        student.setName("name");
        student.setAge(21);
        student.setMobile("12121112");
        student.setDob(new Date(1994, 23, 12));
        student.setStream("stream");

    }

    @Test
    public void shouldBeAbleToAddNewStudent() throws Exception {
        int previousCount = studentDAO.getTotalNumberOfStudent();
        studentDAO.addStudent(student);
        assertEquals(previousCount + 1, studentDAO.getTotalNumberOfStudent());

        studentDAO.deleteStudent(student.getId()); // delete student after test result
    }

    @Test
    public void shouldBeAbleToUpdateStudent() throws Exception {
        studentDAO.addStudent(student); // add a test student
        Student newStudent = new Student();
        newStudent.setId(student.getId());
        newStudent.setName("Enzo");
        newStudent.setStream("Assassin");

        Date dob = new Date(1890, 7, 23);
        newStudent.setDob(dob);

        studentDAO.updateStudent(student.getId(), newStudent);

        newStudent = studentDAO.retrieveStudent(student.getId());
        assertEquals("Enzo", newStudent.getName());
        assertEquals(dob.toString(), newStudent.getDob().toString());
        studentDAO.deleteStudent(student.getId()); //clean up the database after test completes

    }

    @Test
    public void shouldBeAbleToDeleteStudent() throws Exception {
        studentDAO.addStudent(student); // add a dummy student first to test the delete operation, do not delete the real data
        int previousCount = studentDAO.getTotalNumberOfStudent();

        studentDAO.deleteStudent(student.getId());

        assertEquals(previousCount - 1, studentDAO.getTotalNumberOfStudent());
    }
}