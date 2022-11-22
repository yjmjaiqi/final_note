package com.xxzx.final_note.controller;

import com.xxzx.final_note.entity.Note;
import com.xxzx.final_note.entity.Page;
import com.xxzx.final_note.entity.User;
import com.xxzx.final_note.service.Impl.NoteServiceImpl;
import com.xxzx.final_note.service.Impl.PageServiceImpl;
import com.xxzx.final_note.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/note")
public class NotePostController {
    @Autowired
    private UserServiceImpl userService;

    // 新增笔记
    @Autowired
    private NoteServiceImpl noteService;

    @Autowired
    private PageServiceImpl pageService;

    @PostMapping("/addNote")
    public ModelAndView addNote(@RequestParam String title,@RequestParam String content,
                                HttpServletRequest request){
        ModelAndView modelAndView;
        Object user = userService.filter(request);
        modelAndView = userService.grand(user);
        Page page = new Page();
        User users = userService.find_user(request);
        if (modelAndView!=null){
            return modelAndView;
        }
        noteService.Insert(title,content,users.getId());
//        List<Note> notes = noteService.findAllNote(users.getId());
        List<Note> notes = pageService.getNotePage(users.getId(),page);
        modelAndView = new ModelAndView();
        modelAndView.setViewName("notes");
        modelAndView.addObject("notes",notes);
        modelAndView.addObject("username",users.getUsername());
        modelAndView.addObject("page",page);
        return modelAndView;
    }


    // 笔记修改
    @PostMapping("/alterNote")
    public ModelAndView alterNote(@RequestParam Integer id,@RequestParam String title,
                                  @RequestParam String content, HttpServletRequest request){
        ModelAndView modelAndView;
        Object user = userService.filter(request);
        modelAndView = userService.grand(user);
        User users = userService.find_user(request);
        if (modelAndView!=null){
            return modelAndView;
        }
        noteService.update(id,title,content);
//        List<Note> notes = noteService.findAllNote(users.getId());
        modelAndView = new ModelAndView();
        Page page = new Page();
        List<Note> notes = pageService.getNotePage(users.getId(),page);
        modelAndView.setViewName("notes");
        modelAndView.addObject("notes",notes);
        modelAndView.addObject("username",users.getUsername());
        modelAndView.addObject("page",page);
        return modelAndView;
    }

    //    // 首页笔记查询(模糊查询)
//    @PostMapping("/selectNote")
//    public ModelAndView selectNote(@RequestParam String title,HttpServletRequest request){
//        ModelAndView modelAndView;
//        Object user = userService.filter(request);
//        modelAndView = userService.grand(user);
//        if (modelAndView!=null){
//            return modelAndView;
//        }
//        modelAndView = new ModelAndView();
//        Page page = new Page();
//        modelAndView.setViewName("notes");
//        User users = userService.find_user(request);
//        List<Note> notes = noteService.find("%" + title + "%");
////        List<Note> notes = pageService.getNotePage(users.getId(),page);
//        modelAndView.addObject("notes",notes);
//        modelAndView.addObject("username",users.getUsername());
//        modelAndView.addObject("page",new Page());
//        return modelAndView;
//    }

}
