package com.example.controllers;

import com.example.database.StudentDAO;
import com.example.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

@Controller
@RestController
public class MyRestController {

    public Connection getConnection(String dbName, String userName, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, userName, password);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public StudentDAO getDaoObject() {
        StudentDAO studentDAO = new StudentDAO(getConnection("banty", "root", "password"));
        return studentDAO;
    }

    @RequestMapping(value = "/students", produces = "application/json")
    public ArrayList<Student> getAllStudents() {
        return getDaoObject().getAllStudents();
    }

    @RequestMapping(value = "/student/id/{student_id}", produces = "application/json")
    public Student getStudent(@PathVariable("student_id") int id) {
        return getDaoObject().retrieveStudent(id);
    }

    @RequestMapping(value = "/add")
    public ModelAndView showAddStudentForm() {
        ModelAndView modelAndView = new ModelAndView("addStudentForm");
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveStudent(@ModelAttribute("student") Student student){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

}
