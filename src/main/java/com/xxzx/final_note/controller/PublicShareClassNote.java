package com.xxzx.final_note.controller;

import com.xxzx.final_note.entity.Note;
import com.xxzx.final_note.entity.User;
import com.xxzx.final_note.service.Impl.PublicNoteImpl;
import com.xxzx.final_note.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/shareNote")
public class PublicShareClassNote {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PublicNoteImpl publicNote;

    // 共享笔记指定班级
    @GetMapping("/toclass")
    @ResponseBody
    public String toclass(@RequestParam Integer id,@RequestParam String className){
        // 检查指定班级是否存在 存在及共享
        Object o = publicNote.check_class(className);
        System.out.println("o="+o);
        if(o!=null){
            // 共享班级成功
            publicNote.share_class(className,id);
            return "指定共享班级成功";
        }
        return "指定班级不存在";
    }
    // 取消共享笔记指定班级
    @GetMapping("/cancelClass")
    @ResponseBody
    public String cancelClass(@RequestParam String className,@RequestParam Integer id){
        // 检查指定班级是否存在 存在及共享
        Object o = publicNote.check_class(className);
        if(o!=null){
            // 取消共享用户
            publicNote.cancel_class(className,id);
            return "取消共享班级成功";
        }
        return "取消共享班级失败";
    }
    // 共享班级页面渲染
    @GetMapping("/shareClass")
    public ModelAndView shareClass(HttpServletRequest request){
        ModelAndView modelAndView;
        Object user = userService.filter(request);
        modelAndView = userService.grand(user);
        User user1 = userService.find_user(request);
        if (modelAndView!=null){
            return modelAndView;
        }
        modelAndView = new ModelAndView();
        User users = userService.find_user(request);
        modelAndView.setViewName("shareClass");
        modelAndView.addObject("username",users.getUsername());
        System.out.println("user1"+user1);
        modelAndView.addObject("notes",publicNote.publicClassNote(user1.getClassName()));
        return modelAndView;
    }
    // 共享班级模糊查询
    @GetMapping("/shareClassSelect")
    @ResponseBody
    public List<Note> shareClassSelect(@RequestParam String title, HttpServletRequest request){
        Object users = userService.filter(request);
        if (users!=null){
            System.out.println(publicNote.shareClassSelect(userService.find_user(request).getClassName(),"%"+title+"%"));
            return publicNote.shareClassSelect(userService.find_user(request).getClassName(),"%"+title+"%");
        }
        return null;
    }
}
