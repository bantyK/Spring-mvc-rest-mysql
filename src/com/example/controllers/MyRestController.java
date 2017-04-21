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

    @RequestMapping(value = "/students", method = RequestMethod.GET, produces = "application/json")
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

    @RequestMapping(value = "/save", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView saveStudent(@ModelAttribute("student") Student student){
        getDaoObject().addStudent(student);
        return new ModelAndView("redirect:/students");
    }

    @RequestMapping(value = "/update/student/{id}", method = RequestMethod.GET)
    public ModelAndView showAddStudentForm(@PathVariable("id") String id) {
        Student student = getDaoObject().retrieveStudent(Integer.parseInt(id));
        if(student != null) {
            ModelAndView modelAndView = new ModelAndView("updateStudentForm");
            modelAndView.addObject("student", student);
            return modelAndView;
        }
        return new ModelAndView("redirect:/students");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@ModelAttribute Student student){
        getDaoObject().updateStudent(student.getId(),student);
        return new ModelAndView("redirect:/students");
    }
}
