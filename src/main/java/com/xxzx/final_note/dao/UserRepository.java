package com.xxzx.final_note.dao;

import com.xxzx.final_note.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    @Select("select * from user where username = #{username} and password = #{password}")
    public User query(String username, String password);

    // 注册用户
    @Insert("insert into user (username,password,className,academyName) values (#{username},#{password},#{className},#{academyName})")
    public void save(String username,String password,String className,String academyName);

    @Select("select * from user")
    public List<User> findAll();

    // 用户检查是否已注册
    @Select("select * from user where username = #{username}")
    public User checked(String username);

    // 学院id
    @Select("select id from academy where academyName = #{academyName}")
    public Integer academy_id(String academyName);
    // 学院对应班级是否匹配和存在
    @Select("select * from class where className = #{className} and academyid = #{academyid}")
    public Object check_class_academy(String className,Integer academyid);

}
