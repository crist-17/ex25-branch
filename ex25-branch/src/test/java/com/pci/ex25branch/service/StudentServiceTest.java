package com.pci.ex25branch.service;

import com.pci.ex25branch.domain.StudentTest;
import com.pci.ex25branch.mapperTest.StudentMapperTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentServiceTest {

    @Autowired
    private StudentMapperTest studentMapperTest;

    @Test
    @DisplayName("학생 등록후 조회 확인(TDD)")
    void testRegisterAndFind() {
         }

    @Test
    @DisplayName("학생 전체 조회 (TDD)")
    void testFindAll() {
        // given
        StudentTest s3 = StudentTest.builder().name("홍길동3").email("hong3@test.com").age(23).build();
        StudentTest s4 = StudentTest.builder().name("홍길동4").email("hong4@test.com").age(24).build();
        studentMapperTest.insert(s3);
        studentMapperTest.insert(s4);

        // when
        List<StudentTest> students = studentMapperTest.findAll();

        // then
        assertTrue(students.size() >= 2);
        assertEquals("김철수", students.get(0).getName()); // 최신순
    }
}