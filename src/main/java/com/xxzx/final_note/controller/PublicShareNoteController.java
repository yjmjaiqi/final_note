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
public class PublicShareNoteController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PublicNoteImpl publicNote;

    // 共享笔记
    @GetMapping("/share_id")
    public void share_id(@RequestParam Integer id){
        // 共享对应笔记
        publicNote.publicNoteId(id);
    }

    // 取消共享笔记
    @GetMapping("/cancelShare_id")
    public void cancelShare_id(@RequestParam Integer id){
        // 取消共享对应笔记
        publicNote.publicCancelNoteId(id);
    }

    // 共享笔记 页面渲染
    @GetMapping("/share")
    public ModelAndView share(HttpServletRequest request){
        ModelAndView modelAndView;
        Object user = userService.filter(request);
        modelAndView = userService.grand(user);
        if (modelAndView!=null){
            return modelAndView;
        }
        modelAndView = new ModelAndView();
        User users = userService.find_user(request);
        modelAndView.setViewName("shareNote");
        modelAndView.addObject("username",users.getUsername());
        modelAndView.addObject("notes",publicNote.publicNote());
        return modelAndView;
    }

    // 共享笔记页面 模糊查询
    @GetMapping("/selectNote")
    @ResponseBody
    public List<Note> selectNote(String title,HttpServletRequest request){
        Object users = userService.filter(request);
        if (users!=null){
            System.out.println("shareNote"+publicNote.shareSelect("%"+title+"%"));
            return publicNote.shareSelect("%"+title+"%");
        }
        return null;
    }
}
