package com.rushi.springboot.student;


import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
       new Student(1,"rushi Mithagare"),
       new Student(2,"renuka gundre"),
       new Student(3,"Renu R Mithagare")
    );

    @GetMapping("{StudentId}")
    public Student getstudent(@PathVariable("StudentId") Integer StudentId){
        return STUDENTS.stream().filter(student -> StudentId.equals(student.getStudentId()))
                .findFirst().orElseThrow(()-> new IllegalStateException(" student "+ StudentId +" dose not exist "));
    }

}
