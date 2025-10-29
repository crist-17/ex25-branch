package com.pci.ex25branch.controller;

import com.pci.ex25branch.domain.Student;
import com.pci.ex25branch.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students/valid")
@RequiredArgsConstructor
public class StudentController_valid {

    private final StudentService studentService;

    //list 학생목록
    @GetMapping
    public String list(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "student/list_validtest";
    }

    // 등록폼 (빈칸)
    @GetMapping("/new")
    public String createForm(Model model){
        model.addAttribute("student", new Student());
        return "student/form_validtest";
    }

    //등록폼 validtest 화면
    @GetMapping("/new/valid")
    public String createFormValid(Model model){
        model.addAttribute("student", new Student());
        return "student/form_validtest";
    }

    //등록처리
    @PostMapping
    public String create(@Validated @ModelAttribute Student student, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            // 결과에 에러가 있으면 입력창으로 돌아감
            return "student/form_validtest";
        }
        studentService.createStudent(student);
        return "redirect:/students/valid";
    }

    //수정폼
    @GetMapping("/{id}/edit")
    public String updateForm(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.getStudent(id));
        return "student/form_validtest";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Student student, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
        //결과에 에러가 있으면, 입력안하고 입력창으로 돌아가기
            return "student/form_validtest";
        }
        student.setId(id);
        studentService.updateStudent(student);
        return "redirect:/students/valid";
    }

    //삭제하기
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "redirect:/students/valid";
    }

}
