package com.pci.ex25branch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;

@RestController
public class DBconnTest {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/dbconn")
    public String dbconn(){
        try(Connection conn = dataSource.getConnection()) {
            String result = conn.getMetaData().getURL();
            return "DB연결성공: " +  result;
        }catch (Exception e){

            e.printStackTrace();
            return "DB연결실패";
        }

    }


}
