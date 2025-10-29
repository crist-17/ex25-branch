package com.pci.ex25branch.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Student {

    private Long id;

    @NotBlank(message = "이름은 필수항목")
    private String name;

    @Email(message = "이메일형식은 @ 입력필수")
    private String email;

    @Min(value = 1, message = "나이는 1세이상")
    private Integer age;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}