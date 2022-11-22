package com.xxzx.final_note.service.Impl;


import com.xxzx.final_note.entity.User;
import com.xxzx.final_note.dao.UserRepository;
import com.xxzx.final_note.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User query(String username, String password) {
        password = md5(password);
        System.out.println( userRepository.query(username,password));
        Object result = userRepository.query(username,password);
        if (result==null){
            return null;
        }
        return userRepository.query(username,password);
    }


    @Override
    public void save(String username, String password,String className,String academyName) {
        password = md5(password);
        userRepository.save(username,password,className,academyName);
    }

    // 用户注册检查用户是否已经存在
    @Override
    public User checked(String username) {
        System.out.println("checked="+userRepository.checked(username));
        return userRepository.checked(username);
    }

    // 学院id
    @Override
    public Integer academy_id(String academyName) {
        return userRepository.academy_id(academyName);
    }

    // 学院对应班级是否匹配
    @Override
    public Object check_class_academy(String className, Integer academyid) {
        System.out.println(userRepository.check_class_academy(className,academyid));
        return userRepository.check_class_academy(className,academyid);
    }

    // session 过滤拦截非法登录请求
    public Object filter(HttpServletRequest request){
        HttpSession session = request.getSession();
        return session.getAttribute("user");
    }

    // 权限访问
    public ModelAndView grand(Object user){
        ModelAndView modelAndView = new ModelAndView();
        if (user==null){
            modelAndView.setViewName("info");
            modelAndView.addObject("content","无权访问-请先登录");
            modelAndView.addObject("href","/user/login");
            modelAndView.addObject("res","登录");
            return modelAndView;
        }
        return null;
    }

    // 获取储存用户
    public User find_user(HttpServletRequest request){
        HttpSession session = request.getSession();
        User users = (User) session.getAttribute("user");
        return query(users.getUsername(),users.getPassword());
    }

    //    MD5加密
    private static String md5(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("md5");

            byte[] bytes = md.digest(password.getBytes());

            String str = Base64.getEncoder().encodeToString(bytes);

            return str;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


}
