package com.xxzx.final_note.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

@Data
public class User {
    private Integer id;
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @Size(min = 6,max = 16,message = "密码为6~16位")
    private String password;
    @NotEmpty(message = "班级号不能为空")
    private String className;
    @NotEmpty(message = "学院不能不能为空")
    private String academyName;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", className='" + className + '\'' +
                ", academyName='" + academyName + '\'' +
                '}';
    }

    public User(Integer id, String username, String password, String className, String academyName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.className = className;
        this.academyName = academyName;
    }

    public User() {
    }
}
