package com.xxzx.final_note.service;

import com.xxzx.final_note.entity.Note;
import com.xxzx.final_note.entity.Page;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PageService {
    // 查询所有数据
    public List<Note> getNotePage(Integer id,Page page);

//    public List<Note> getNotePages(Page page);


}
