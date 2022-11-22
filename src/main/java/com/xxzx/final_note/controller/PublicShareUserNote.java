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
public class PublicShareUserNote {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PublicNoteImpl publicNote;

    // 共享笔记指定用户
    @GetMapping("/touser")
    @ResponseBody
    public String touser(@RequestParam Integer id,@RequestParam String username){
        // 检查指定用户是否存在 存在及共享
        Object o = publicNote.check_user(username);
        System.out.println("o="+o);
        if(o!=null){
            // 共享用户成功
            publicNote.share_user(username,id);
            return "指定共享用户成功";
        }
        return "指定用户不存在";
    }
    // 取消共享笔记指定用户
    @GetMapping("/cancelUser")
    @ResponseBody
    public String cancelUser(@RequestParam String username,@RequestParam Integer id){
        // 检查指定用户是否存在 存在及共享
        Object o = publicNote.check_user(username);
        if(o!=null){
            // 取消共享用户
            publicNote.cancel_user(username,id);
            return "取消共享用户成功";
        }
        return "取消共享用户失败";
    }
    // 共享用户页面渲染
    @GetMapping("/shareUser")
    public ModelAndView shareUser(HttpServletRequest request){
        ModelAndView modelAndView;
        Object user = userService.filter(request);
        modelAndView = userService.grand(user);
        if (modelAndView!=null){
            return modelAndView;
        }
        modelAndView = new ModelAndView();
        User users = userService.find_user(request);
        modelAndView.setViewName("shareUser");
        modelAndView.addObject("username",users.getUsername());
        modelAndView.addObject("notes",publicNote.publicUserNote(users.getUsername()));
        return modelAndView;
    }
    // 共享用户模糊查询
    @GetMapping("/shareUserSelect")
    @ResponseBody
    public List<Note> shareUserSelect(@RequestParam String title, HttpServletRequest request){
        Object users = userService.filter(request);
        if (users!=null){
            System.out.println(publicNote.shareUserSelect(userService.find_user(request).getUsername(),"%"+title+"%"));
            return publicNote.shareUserSelect(userService.find_user(request).getUsername(),"%"+title+"%");
        }
        return null;
    }
}
