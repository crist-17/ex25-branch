package com.pci.ex25branch.mapper;


import com.pci.ex25branch.domain.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {


    List<Student> findALl();

    Student findById(Long id);

    void insert(Student student);

    void update(Student student);

    void delete(Long id);

//    Student findById();
}
