package com.pci.ex25branch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pci.ex25branch.domain.Student;
import com.pci.ex25branch.service.StudentService;

import lombok.RequiredArgsConstructor;





@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    // 화면: 전체 학생 목록
    @GetMapping
    public String list(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student/list";
    }

    // form 화면: 새로운 학생정보를 입력하기위한 빈화면.
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/form";
    }

    //등록처리 :학생정보 기록후 저장버튼 클릭을 하면,학생정보를 insert

    @PostMapping
    public String create(@ModelAttribute Student student) {
        //이미 학생이 저장이 완료됨
        studentService.createStudent(student);

        return "redirect:/students";
    }

    // 수정폼
    @GetMapping("/{id}/edit")
    public String updateForm(@PathVariable Long id, Model model) {

        model.addAttribute("student", studentService.getStudent(id));
        return "student/form";
    }

    //수정처리 : 수정폼 보이기
    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Student student) {
        student.setId(id);
        studentService.updateStudent(student);

        return "redirect:/students";
    }

    //삭제처리
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";


    }



}