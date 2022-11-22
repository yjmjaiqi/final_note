package com.xxzx.final_note.service;

import com.xxzx.final_note.entity.Note;

import java.util.List;

public interface NoteService {
    // 增
    public void Insert(String title, String content, Integer id);
    // 删
    public void Delete(Integer id);
    // 改
    public List<Note> find(String title,Integer id);
    // 查
    public void update(Integer id, String title, String content);
//    // 笔记首页数据渲染
//    public List<Note> findAllNote(Integer id);
    // 修改页面笔记渲染
    public Note updateNote(Integer id);
}
