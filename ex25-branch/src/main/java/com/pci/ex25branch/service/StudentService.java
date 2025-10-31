package com.pci.ex25branch.service;

import com.pci.ex25branch.domain.Student;
import com.pci.ex25branch.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentMapper studentMapper;

    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {
//      매퍼 오브젝트에게 값을 요청
        return studentMapper.findALl();

    }

    public Student getStudent(Long id) {
        return studentMapper.findById(id);
    }
    @Transactional
    public void createStudent(Student student) {
        studentMapper.insert(student);
    }
    @Transactional
    public void updateStudent(Student student) {
        studentMapper.update(student);
    }
    @Transactional
    public void deleteStudent(Long id) {
        studentMapper.delete(id);
    }


//
//    public MyStudent getStudents() {
//    //자바방신
//        MyStudent myStudnet = new MyStudent();
//        myStudnet.setName("홍길동");
//        myStudnet.setAge(10);
//        return myStudnet;
//    }
//
//
//    public String getStudentName() {
//       //스프링방식
//       MyStudent myStudent2 =  new MyStudent();
//       myStudent2.setName("일지매222");
//       myStudent2.setAge(20);
//
//       return myStudent2.getName();
//    }





}
