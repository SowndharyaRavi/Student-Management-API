package com.example.Student.Management;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {

    Map<Integer,Student> dB=new HashMap<>();

    public String addStudent(Student student){
        int admnNo=student.getAdmnNo();
        dB.put(admnNo,student);
        return "Student added Successfully";
    }

    public Student getStudent(int admnNo){
        if(dB.containsKey(admnNo)){
            return dB.get(admnNo);
        }
        else{
            return null;
        }

    }

    public String deleteStudent(int admnNo){
        if(dB.containsKey(admnNo)){
            dB.remove(admnNo);
            return "Student removed";
        }
        else{
            return "Invalid admnNo";
        }
    }

    public String updateStudent(Student student){
        int admnNo= student.getAdmnNo();
        if(dB.containsKey(admnNo)){
            dB.put(admnNo,student);
            return "details updated";
        }
        else{
            return "Invalid admnNo";
        }
    }
}
