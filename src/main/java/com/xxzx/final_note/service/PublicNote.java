package com.xxzx.final_note.service;

import com.xxzx.final_note.entity.Note;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PublicNote {
    // 共享笔记
    public void publicNoteId(Integer id);
    // 取消共享笔记
    public void publicCancelNoteId(Integer id);
    // 共享笔记页面渲染
    public List<Note> publicNote();
    // 共享笔记页笔记模糊查询
    public List<Note> shareSelect(String title);


    // 用户
    // 查询指定用户是否存在
    public Object check_user(String username);
    // 共享笔记指定用户
    public void share_user(String userName,Integer note_id);
    // 共享笔记取消指定用户
    public void cancel_user(String userName,Integer id);
    // 共享用户笔记页面渲染
    public List<Note> publicUserNote(String username);
    // 共享用户笔记页笔记模糊查询
    public List<Note> shareUserSelect(String username,String title);


    // 班级
    // 查询指定班级是否存在
    public Object check_class(String className);
    // 共享笔记指定班级
    public void share_class(String className,Integer note_id);
    // 共享笔记取消指定班级
    public void cancel_class(String className,Integer id);
    // 共享班级笔记页面渲染
    public List<Note> publicClassNote(String className);
    // 共享班级笔记页笔记模糊查询
    public List<Note> shareClassSelect(String className,String title);


    // 院校
    // 查询指定院校是否存在
    public Object check_academy(String academyName);
    // 共享笔记指定院校
    public void share_academy(String academyName, Integer note_id);
    // 共享笔记取消指定院校
    public void cancel_academy(String academyName,Integer id);
    // 共享院校笔记页面渲染
    public List<Note> publicAcademyNote(String academyName);
    // 共享院校笔记页笔记模糊查询
    public List<Note> shareAcademySelect(String academyName,String title);
}
