package com.example.school.services;

import com.example.school.entities.Student;

import java.util.List;

public interface service {
    public List<Student> getStudents();
    public  Student getStudent(long studentid);
    public Student addstudent(Student student);
    public Student editstudent(Student student);
    public void deletestudent(long studentid);
}
