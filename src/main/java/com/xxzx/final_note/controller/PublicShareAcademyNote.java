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
public class PublicShareAcademyNote {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PublicNoteImpl publicNote;

    // 共享笔记指定院校
    @GetMapping("/toacademy")
    @ResponseBody
    public String toacademy(@RequestParam Integer id,@RequestParam String academyName){
        // 检查指定院校是否存在 存在及共享
        Object o = publicNote.check_academy(academyName);
        System.out.println("o="+o);
        if(o!=null){
            // 共享院校成功
            publicNote.share_academy(academyName,id);
            return "指定共享院校成功";
        }
        return "指定院校不存在";
    }
    // 取消共享笔记指定院校
    @GetMapping("/cancelAcademy")
    @ResponseBody
    public String cancelClass(@RequestParam String academyName,@RequestParam Integer id){
        // 检查指定院校是否存在 存在及共享
        Object o = publicNote.check_academy(academyName);
        if(o!=null){
            // 取消共享院校
            publicNote.cancel_academy(academyName,id);
            return "取消共享院校成功";
        }
        return "取消共享院校失败";
    }
    // 共享院校页面渲染
    @GetMapping("/shareAcademy")
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
        modelAndView.setViewName("shareAcademy");
        modelAndView.addObject("username",users.getUsername());
        System.out.println("user1"+user1);
        modelAndView.addObject("notes",publicNote.publicAcademyNote(user1.getAcademyName()));
        return modelAndView;
    }
    // 共享院校模糊查询
    @GetMapping("/shareAcademySelect")
    @ResponseBody
    public List<Note> shareClassSelect(@RequestParam String title, HttpServletRequest request){
        Object users = userService.filter(request);
        if (users!=null){
            System.out.println(publicNote.shareAcademySelect(userService.find_user(request).getAcademyName(),"%"+title+"%"));
            return publicNote.shareAcademySelect(userService.find_user(request).getAcademyName(),"%"+title+"%");
        }
        return null;
    }
}
