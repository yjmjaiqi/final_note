package com.xxzx.final_note.service.Impl;

import com.xxzx.final_note.dao.NoteRepository;
import com.xxzx.final_note.entity.Note;
import com.xxzx.final_note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    @Transactional
    public void Insert(String title, String content,Integer id) {
        noteRepository.Insert(title,content,id);
    }

    @Override
    @Transactional
    public void Delete(Integer id) {
        noteRepository.Delete(id);
    }

    @Override
    public List<Note> find(String title,Integer id) {
        return noteRepository.find(title,id);
    }

    @Override
    @Transactional
    public void update(Integer id, String title, String content) {
        noteRepository.update(id,title,content);
    }

//    @Override
//    @Transactional
//    public List<Note> findAllNote(Integer id){
//        return noteRepository.findAllNote(id);
//    }

    // 修改页面笔记渲染
    @Override
    @Transactional
    public Note updateNote(Integer id){
        return noteRepository.findNote(id);
    }
}
