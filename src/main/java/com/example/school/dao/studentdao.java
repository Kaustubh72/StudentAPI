package com.example.school.dao;

import com.example.school.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentdao extends JpaRepository<Student,Long> {

}
