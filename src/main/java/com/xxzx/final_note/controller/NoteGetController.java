package com.xxzx.final_note.controller;

import com.xxzx.final_note.entity.Note;
import com.xxzx.final_note.entity.Page;
import com.xxzx.final_note.entity.User;
import com.xxzx.final_note.service.Impl.NoteServiceImpl;
import com.xxzx.final_note.service.Impl.PageServiceImpl;
import com.xxzx.final_note.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/note")
public class NoteGetController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private NoteServiceImpl noteService;

    @Autowired
    private PageServiceImpl pageService;

    @GetMapping("/addNote")
    public ModelAndView addArticle(HttpServletRequest request){
        ModelAndView modelAndView;
        Object user = userService.filter(request);
        modelAndView = userService.grand(user);
        if (modelAndView!=null){
            return modelAndView;
        }
        modelAndView = new ModelAndView();
        modelAndView.setViewName("addNote");
        User username = userService.find_user(request);
        modelAndView.addObject("username",username.getUsername());
        return modelAndView;
    }

    @GetMapping("/alterNote")
    public ModelAndView alterNote(@RequestParam Integer id, HttpServletRequest request){
        ModelAndView modelAndView;
        Object user = userService.filter(request);
        modelAndView = userService.grand(user);
        User username = userService.find_user(request);
        if (modelAndView!=null){
            return modelAndView;
        }
        modelAndView = new ModelAndView();
        modelAndView.setViewName("alterNote");
        modelAndView.addObject("username",username.getUsername());
        modelAndView.addObject("note",noteService.updateNote(id));
        return modelAndView;
    }


    @GetMapping("/notes")
    public ModelAndView notes(HttpServletRequest request){
        ModelAndView modelAndView;
        Object user = userService.filter(request);
        modelAndView = userService.grand(user);
        if (modelAndView!=null){
            return modelAndView;
        }
        modelAndView = new ModelAndView();
        Page page = new Page();
        modelAndView.setViewName("notes");
        User users = userService.find_user(request);
//        List<Note> notes = noteService.findAllNote(users.getId());
        List<Note> notes = pageService.getNotePage(users.getId(),page);
        modelAndView.addObject("notes",notes);
        modelAndView.addObject("username",users.getUsername());
        modelAndView.addObject("page",page);
        return modelAndView;
    }

    // 删除笔记
    @GetMapping("/deleteNote")
    public ModelAndView deleteNote(@RequestParam Integer id, HttpServletRequest request){
        ModelAndView modelAndView;
        Object user = userService.filter(request);
        modelAndView = userService.grand(user);
        if (modelAndView!=null){
            return modelAndView;
        }
        noteService.Delete(id);
        modelAndView = new ModelAndView();
        Page page = new Page();
        modelAndView.setViewName("notes");
        User users = userService.find_user(request);
//        List<Note> notes = noteService.findAllNote(users.getId());
        List<Note> notes = pageService.getNotePage(users.getId(),page);
        modelAndView.addObject("notes",notes);
        modelAndView.addObject("username",users.getUsername());
        modelAndView.addObject("page",page);
        return modelAndView;
    }
    // 首页笔记查询(模糊查询)
    @GetMapping("/selectNote")
    @ResponseBody
    public List<Note> selectNote(@RequestParam String title, HttpServletRequest request){
        Object users = userService.filter(request);
        if (users!=null){
            User user = userService.find_user(request);
            return noteService.find("%" + title + "%",user.getId());
        }
        return null;
    }


    // 首页分页数据
    @GetMapping("/page")
    @ResponseBody
    public List<Note> page(Page page,HttpServletRequest request){
        Object users = userService.filter(request);
        if (users!=null){
            User user = userService.find_user(request);
            System.out.println(pageService.getNotePage(user.getId(),page));
            return pageService.getNotePage(user.getId(),page);
        }
        return null;
    }
}
