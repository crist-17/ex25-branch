package com.pci.ex25branch.controller;

import com.pci.ex25branch.domain.Student;
import com.pci.ex25branch.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentRestConroller {

    private final StudentService studentService;

    @GetMapping
    public List<Student> list(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> detail(@PathVariable Long id){
        Student student = studentService.getStudent(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student){
       studentService.createStudent(student);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student){
        student.setId(id);
        studentService.updateStudent(student);
        return ResponseEntity.ok(student);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
}
//    @GetMapping
//    public MyStudent myStudent(){
//        return studentService.getStudents();
//    }

//    @GetMapping
//    public String myStudent(){
//        return studentService.getStudentName();
//    }





}
