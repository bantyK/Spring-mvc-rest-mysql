package com.example.database;

import com.example.model.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.sql.DataSource;
import java.sql.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StudentDAOTests {

    @Mock
    private DataSource ds;

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    private Student student;

    @Before
    public void setUp() throws Exception {
        assertNotNull(ds);
        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
        when(ds.getConnection()).thenReturn(connection);

        student = new Student(2, "Ezio", 21, "9612121212", new Date(1994, 7, 29), "Computer");

        when(resultSet.first()).thenReturn(true);

        when(resultSet.getInt(1)).thenReturn(2);
        when(resultSet.getString(2)).thenReturn("Ezio");
        when(resultSet.getInt(3)).thenReturn(21);
        when(resultSet.getString(4)).thenReturn("9612121212");
        when(resultSet.getString(5)).thenReturn(new Date(1994, 7, 29).toString());
        when(resultSet.getString(6)).thenReturn("Computer");

        when(preparedStatement.executeQuery()).thenReturn(resultSet);

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowErrorWhenStudentIsNull() throws Exception {
        new StudentDAO(ds).addStudent(null);

    }

    @Test
    public void createNewStudentShouldNotThrowException() throws Exception {
        new StudentDAO(ds).addStudent(student);
    }

    @Test
    public void shoudlBeAbleToRetrieveStudentFromDB() throws Exception {
        StudentDAO studentDAO = new StudentDAO(ds);
        studentDAO.addStudent(student);
        Student student1 = studentDAO.retrieveStudent(2);
        assertEquals(student.getName(),student1.getName());
    }
}