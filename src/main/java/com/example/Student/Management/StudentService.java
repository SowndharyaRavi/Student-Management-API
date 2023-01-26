package com.example.Student.Management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student){
        return studentRepository.addStudent(student);
    }

    public Student getStudent(int admnNo){
        return studentRepository.getStudent(admnNo);
    }

    public String deleteStudent(int admnNo){
        return studentRepository.deleteStudent(admnNo);
    }

    public String updateStudent(Student student){
        return studentRepository.updateStudent(student);
    }
}
