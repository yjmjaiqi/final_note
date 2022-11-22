package com.xxzx.final_note.service;

import com.xxzx.final_note.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserService {
    public User query(String username, String password);

    public void save(String username,String password,String className,String academyName);

    // 用户注册检查用户是否已经存在
    public User checked(String username);
//    public List<User> findAll();

    // 学院id
    public Integer academy_id(String academyName);
    // 学院对应班级是否匹配
    public Object check_class_academy(String className,Integer academyid);

}
