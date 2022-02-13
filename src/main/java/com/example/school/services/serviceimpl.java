package com.example.school.services;

import com.example.school.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.example.school.dao.studentdao;
@Service
public class serviceimpl implements service {

    @Autowired
    private studentdao sdao;
//    List<Student> list;
//    public serviceimpl()
//    {
//        list=new ArrayList<>();
//        list.add(new Student(100,"Sridhar",8,"Karnataka",987654200));
//        list.add(new Student(101,"Kaustubh",12,"Varanasi",123452100));
//    }

    @Override
    public List<Student> getStudents() {

        return sdao.findAll();
    }

    @Override
    public Student getStudent(long studentid)
    {
        Student s=null;
//        for(Student st: sdao.findAll())
//        {
//            if(st.getId()==studentid)
//            {
//                s=st;
//                break;
//            }
//        }
        //return s;
        try {
            s = sdao.findById(studentid).get();
            return s;
        }catch (Exception e) {
            return null;
        }
    }

    @Override
    public Student addstudent(Student student)
    {
//        list.add(student);
//        return student;
        sdao.save(student);
        return student;
    }

    @Override
    public Student editstudent(Student student) {
//        for(Student st:list)
//        {
//            if(st.getId()==student.getId())
//            {
//                st.setName(student.getName());
//                st.setAddress(student.getAddress());
//                st.setPhone(student.getPhone());
//                st.setStandard(student.getStandard());
//                break;
//            }
//        }
//        return student;
        sdao.save(student);
        return student;
    }

    @Override
    public void deletestudent(long studentid) {

     //   list=this.list.stream().filter(e->e.getId()!=studentid).collect(Collectors.toList());
        sdao.delete(sdao.getOne(studentid));
    }
}
