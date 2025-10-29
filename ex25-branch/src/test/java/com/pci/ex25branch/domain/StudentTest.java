package com.pci.ex25branch.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class StudentTest {

    private Long id;

    private String name;

    private String email;

    private Integer age;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
