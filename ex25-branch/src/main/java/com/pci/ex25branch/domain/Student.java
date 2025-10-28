package com.pci.ex25branch.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Student {

    private Long id;

    @NotBlank(message = "이름은 필수항목")
    private String name;

    @Email(message = "이메일형식@ 입력필수")
    private String email;

    @Min(value = 1, message = "나이는 1세이상")
    private Integer age;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}