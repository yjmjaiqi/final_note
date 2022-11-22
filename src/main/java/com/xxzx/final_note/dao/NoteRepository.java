package com.xxzx.final_note.dao;

import com.xxzx.final_note.entity.Note;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository {
    // 新增笔记
    @Insert("insert into note(note_title,note_content,note_time,userid) values(#{title},#{content},current_timestamp,#{id})")
    public void Insert(String title, String content, Integer id);

    // 删除笔记
    @Delete("delete from note where id = #{id}")
    public void Delete(Integer id);

    // 修改笔记
    @Update("update note set note_title = #{title},note_content = #{content},alter_time = current_timestamp where id = #{id}")
    public void update(Integer id,String title,String content);

    // 修改页面笔记渲染
    @Select("select * from note where id = #{id}")
    public Note findNote(Integer id);

    // 模糊查询
    @Select("select * from note where note_title like #{title} and userid = #{id}")
    public List<Note> find(String title,Integer id);
    // 笔记首页数据渲染
//    @Select("select * from note where userid = #{id} order by id desc limit 3")
//    public List<Note> findAllNote(Integer id);

}
