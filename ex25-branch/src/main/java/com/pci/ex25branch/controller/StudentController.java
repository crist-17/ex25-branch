package com.pci.ex25branch.controller;


import com.pci.ex25branch.domain.Student;
import com.pci.ex25branch.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    // list 화면
    @GetMapping
    public String list(Model model) {
        model.addAttribute("students", studentService.getAllStudents());

        return "student/list";
    }

    //등록 form 화면 (빈칸)
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("student", new Student());

        return "student/form";
    }

    //등록처리 정보기록후 클릭 > list 로 전환
    @PostMapping
    public String create(@ModelAttribute Student student) {
        studentService.createStudent(student);
        return "redirect:/students";
    }

    //수정 폼
    @GetMapping("/{id}/edit")
    public String updateForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudent(id));
    return "student/form";
    }

    // 수정 처리
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
