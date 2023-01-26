package com.example.Student.Management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

  @Autowired
  StudentService studentService;

   //adding the information
   @PostMapping("/add_student")
   public ResponseEntity addStudent(@RequestBody Student student){
      String response= studentService.addStudent(student);
      return new ResponseEntity<>(response, HttpStatus.CREATED);
   }

   //get the information
   @GetMapping("/get_student")
   public ResponseEntity getStudent(@RequestParam("admnNo") int admnNo){
      Student student= studentService.getStudent(admnNo);
      if(student==null) {
          return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
      }
      else{
          return new ResponseEntity<>(student,HttpStatus.FOUND);
      }
   }

   //delete the information
   @DeleteMapping("/delete_student")
   public ResponseEntity deleteStudent(@RequestParam("admnNo") int admnNo){
      String response=studentService.deleteStudent(admnNo);
      if(response.equals("Invalid admnNo")) {
          return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
      }
      else{
          return new ResponseEntity<>(response,HttpStatus.FOUND);
      }
   }

   //update the information
   @PutMapping("/update_student")
   public ResponseEntity updateStudent(@RequestBody Student student){
      String response= studentService.updateStudent(student);
       if(response.equals("Invalid admnNo")) {
           return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
       }
       else{
           return new ResponseEntity<>(response,HttpStatus.FOUND);
       }
   }
}
