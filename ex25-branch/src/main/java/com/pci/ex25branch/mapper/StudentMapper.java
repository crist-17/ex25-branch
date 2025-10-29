package com.pci.ex25branch.mapper;

import com.pci.ex25branch.domain.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("SELECT * from student ORDER BY id DESC ")
    List<Student> findAll();


	@Select("SELECT * FROM student WHERE id = #{id}")
    Student findById(Long id);


	@Insert("INSERT INTO student(NAME, email, age) \r\n"
			+ "  	VALUES (#{name}, #{email}, #{age})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void insert(Student student);


	@Update("UPDATE student\r\n"
			+ "	SET NAME = #{name}, email = #{email}, age = #{age}\r\n"
			+ "	WHERE id = #{id}")
	void update(Student student);


	@Delete("DELETE FROM student WHERE id = #{id}")
	void delete(Long id);
}