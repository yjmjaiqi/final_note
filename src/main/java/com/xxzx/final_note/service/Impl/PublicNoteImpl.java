package com.xxzx.final_note.service.Impl;

import com.xxzx.final_note.dao.PublicNoteRepository;
import com.xxzx.final_note.entity.Note;
import com.xxzx.final_note.service.PublicNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicNoteImpl implements PublicNote {
    @Autowired
    private PublicNoteRepository publicNoteRepository;
    // 共享笔记
    @Override
    public void publicNoteId(Integer id) {
        publicNoteRepository.publicNoteId(id);
    }
    // 取消共享笔记
    @Override
    public void publicCancelNoteId(Integer id) {
        publicNoteRepository.publicCancelNoteId(id);
    }
    // 共享笔记页面渲染
    @Override
    public List<Note> publicNote() {
        return publicNoteRepository.publicNote();
    }
    // 共享笔记页笔记模糊查询
    @Override
    public List<Note> shareSelect(String title) {
        return publicNoteRepository.shareSelect(title);
    }

    // 用户
    // 查询指定用户是否存在
    @Override
    public Object check_user(String username) {
        System.out.println("check_user="+publicNoteRepository.check_user(username));
        return publicNoteRepository.check_user(username);
    }
    // 共享笔记指定用户
    @Override
    public void share_user(String userName, Integer note_id) {
        publicNoteRepository.share_user(userName, note_id);
    }
    // 共享笔记取消指定用户
    @Override
    public void cancel_user(String userName,Integer id) {
        publicNoteRepository.cancel_user(userName,id);
    }
    // 共享用户笔记页面渲染
    @Override
    public List<Note> publicUserNote(String username) {
        return publicNoteRepository.publicUserNote(username);
    }
    // 共享用户笔记页笔记模糊查询
    @Override
    public List<Note> shareUserSelect(String username, String title) {
        return publicNoteRepository.shareUserSelect(username,title);
    }

    // 班级
    // 查询指定班级是否存在
    @Override
    public Object check_class(String className) {
        return publicNoteRepository.check_class(className);
    }
    // 共享笔记指定班级
    @Override
    public void share_class(String className, Integer note_id) {
        publicNoteRepository.share_class(className, note_id);
    }
    // 共享笔记取消指定班级
    @Override
    public void cancel_class(String className,Integer id) {
        publicNoteRepository.cancel_class(className, id);
    }
    // 共享班级笔记页面渲染
    @Override
    public List<Note> publicClassNote(String className) {
        return publicNoteRepository.publicClassNote(className);
    }
    // 共享班级笔记页笔记模糊查询
    @Override
    public List<Note> shareClassSelect(String className, String title) {
        return publicNoteRepository.shareClassSelect(className,title);
    }

    // 院校
    // 查询指定院校是否存在
    @Override
    public Object check_academy(String academyName) {
        return publicNoteRepository.check_academy(academyName);
    }
    // 共享笔记指定院校
    @Override
    public void share_academy(String academyName, Integer note_id) {
        publicNoteRepository.share_academy(academyName, note_id);
    }
    // 共享笔记取消指定院校
    @Override
    public void cancel_academy(String academyName,Integer id) {
        publicNoteRepository.cancel_academy(academyName,id);
    }

    @Override
    public List<Note> publicAcademyNote(String academyName) {
        return publicNoteRepository.publicAcademyNote(academyName);
    }

    @Override
    public List<Note> shareAcademySelect(String academyName, String title) {
        return publicNoteRepository.shareAcademySelect(academyName,title);
    }

}
