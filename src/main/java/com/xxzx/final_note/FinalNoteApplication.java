package com.xxzx.final_note;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.xxzx.final_note.dao")
@EnableTransactionManagement
public class FinalNoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalNoteApplication.class, args);
    }

}
