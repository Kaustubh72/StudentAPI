package com.example.school.controller;

import com.example.school.entities.Student;
import com.example.school.services.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class controller {

    @Autowired
    private service service;

    @GetMapping("/")
    public String home() {
        return "Welcome to my Kaustubh Convent School";
    }
    @GetMapping("/student")
    public List<Student> getStudents() {
        return this.service.getStudents();
    }
    @GetMapping("/student/{studentid}")
    public Student getStudent(@PathVariable String studentid)
    {
        return this.service.getStudent(Long.parseLong(studentid));
    }

    @PostMapping(path = "/student",consumes = "application/json")
    public  Student addstudent(@RequestBody Student student)
    {
        return this.service.addstudent(student);
    }
    @PutMapping("/student")
    public Student editstudent(@RequestBody Student student)
    {
        return this.service.editstudent(student);
    }
    @DeleteMapping("student/{studentid}")
    public ResponseEntity<HttpStatus> deletestudent(@PathVariable String studentid){
        try {
            this.service.deletestudent(Long.parseLong(studentid));
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
