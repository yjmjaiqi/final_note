package com.xxzx.final_note.controller;

import com.xxzx.final_note.entity.Note;
import com.xxzx.final_note.entity.Page;
import com.xxzx.final_note.entity.User;
import com.xxzx.final_note.service.Impl.NoteServiceImpl;
import com.xxzx.final_note.service.Impl.PageServiceImpl;
import com.xxzx.final_note.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class Register_Login {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private NoteServiceImpl noteService;

    @Autowired
    private PageServiceImpl pageService;

    @GetMapping("/register")
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }
    @PostMapping("/register")
    public ModelAndView PostRegister(@Valid User user, BindingResult bindingResult){
//        System.out.println("user="+username+":"+password);
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(user);
        System.out.println(user.getUsername()+user.getPassword());
        // 检测注册账户班级院校是否存在
        Integer academyid = userService.academy_id(user.getAcademyName());
        Object o = userService.check_class_academy(user.getClassName(),academyid);
        System.out.println("o="+o);
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("info");
            modelAndView.addObject("content","注册失败");
            modelAndView.addObject("href","/user/register");
            modelAndView.addObject("res","注册");
            return modelAndView;
        }else if(userService.checked(user.getUsername())!=null){
            modelAndView.setViewName("info");
            modelAndView.addObject("content","用户已存在");
            modelAndView.addObject("href","/user/register");
            modelAndView.addObject("res","注册");
            return modelAndView;
        }else if(o==null){
            modelAndView.setViewName("info");
            modelAndView.addObject("content","院校班级信息错误");
            modelAndView.addObject("href","/user/register");
            modelAndView.addObject("res","注册");
            return modelAndView;
        }
        modelAndView.setViewName("login");
        userService.save(user.getUsername(),user.getPassword(),user.getClassName(),user.getAcademyName());
        return modelAndView;
    }

    //  验证码登录
    @RequestMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView tologin(@Valid @RequestParam String username,
                                @Valid @RequestParam String password,
                                @RequestParam String code, HttpServletRequest request){
//        StringBuilder email = new StringBuilder(code);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        HttpSession session = request.getSession();
        request.getSession().setAttribute("user",user);
        String codes = session.getAttribute("code").toString();
        System.out.println("code="+code);
        System.out.println("user="+username+":"+password);
//        System.out.println("比较="+(code.equals(codes)));
        ModelAndView modelAndView = new ModelAndView();
        Page page = new Page();
        Object result = userService.query(username,password);
        if(result==null){
            modelAndView.setViewName("info");
            modelAndView.addObject("content","用户名或密码错误");
            modelAndView.addObject("href","/user/login");
            modelAndView.addObject("res","登录");
            return modelAndView;
        }else if(!code.equals(codes)){
            modelAndView.setViewName("info");
            modelAndView.addObject("content","邮箱验证码错误");
            modelAndView.addObject("href","/user/login");
            modelAndView.addObject("res","登录");
            return modelAndView;
        }
        User users = userService.find_user(request);
        List<Note> notes = pageService.getNotePage(users.getId(),page);
        modelAndView.setViewName("notes");
        modelAndView.addObject("notes",notes);
        modelAndView.addObject("username",users.getUsername());
        modelAndView.addObject("page",page);
        return modelAndView;
    }
}
