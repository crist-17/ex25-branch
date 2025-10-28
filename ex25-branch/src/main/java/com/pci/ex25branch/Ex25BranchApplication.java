package com.pci.ex25branch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Ex25BranchApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ex25BranchApplication.class, args);
    }

}
