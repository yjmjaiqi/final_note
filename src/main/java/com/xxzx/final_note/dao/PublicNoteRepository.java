package com.xxzx.final_note.dao;

import com.xxzx.final_note.entity.Note;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicNoteRepository {
    // 共享笔记
    @Update("update note set shareid = 'TRUE' where id = #{id}")
    public void publicNoteId(Integer id);
    // 取消共享笔记
    @Update("update note set shareid = 'FALSE' where id = #{id}")
    public void publicCancelNoteId(Integer id);
    // 共享笔记页面渲染
    @Select("select id,note_title,note_content,note_time,alter_time,userid,shareid from note where shareid = 'TRUE'")
    public List<Note> publicNote();
    // 共享笔记页笔记模糊查询
    @Select("select id,note_title,note_content,note_time,alter_time,userid,shareid  from note where shareid = 'TRUE' and note_title like #{title}")
    public List<Note> shareSelect(String title);


    // 用户
    // 查询指定用户是否存在
    @Select("select * from user where username = #{username}")
    public Object check_user(String username);
    // 共享笔记指定用户
    @Insert("insert into user_note(userName,note_id) values(#{userName},#{note_id})")
    public void share_user(String userName,Integer note_id);
    // 共享笔记取消指定用户
    @Delete("delete from user_note where userName = #{username} and note_id = #{id}")
    public void cancel_user(String username,Integer id);
    // 共享用户笔记页面渲染
    @Select("select id,note_title,note_content,note_time,alter_time,userid,shareid  from note n inner join user_note u on n.id = u.note_id\n" +
            "and u.userName = #{username}")
    public List<Note> publicUserNote(String username);
    // 共享用户笔记页笔记模糊查询
    @Select("select id,note_title,note_content,note_time,alter_time,userid,shareid  from note n inner join user_note u\n" +
            "on n.id = u.note_id and u.userName = #{username} and n.note_title like #{title}")
    public List<Note> shareUserSelect(String username,String title);



    // 班级
    // 查询指定班级是否存在
    @Select("select * from class where className = #{className}")
    public Object check_class(String className);
    // 共享笔记指定班级
    @Insert("insert into class_note(className,note_id) values(#{className},#{note_id})")
    public void share_class(String className,Integer note_id);
    // 共享笔记取消指定班级
    @Delete("delete from class_note where className = #{className} and note_id = #{id}")
    public void cancel_class(String className,Integer id);
    // 共享班级笔记页面渲染
    @Select("select id,note_title,note_content,note_time,alter_time,userid,shareid  from note n inner join class_note c " +
            "on n.id = c.note_id and c.className = #{className}")
    public List<Note> publicClassNote(String className);
    // 共享班级笔记页笔记模糊查询
    @Select("select id,note_title,note_content,note_time,alter_time,userid,shareid  from note n inner join class_note c " +
            "on n.id = c.note_id and c.className = #{className} and n.note_title like #{title}")
    public List<Note> shareClassSelect(String className,String title);


    // 院校
    // 查询指定院校是否存在
    @Select("select * from academy where academyName = #{academyName}")
    public Object check_academy(String academyName);
    // 共享笔记指定院校
    @Insert("insert into academy_note(academyName,note_id) values(#{academyName},#{note_id})")
    public void share_academy(String academyName,Integer note_id);
    // 共享笔记取消指定院校
    @Delete("delete from academy_note where academyName = #{academyName} and note_id = #{id}")
    public void cancel_academy(String academyName,Integer id);
    // 共享院校笔记页面渲染
    @Select("select id,note_title,note_content,note_time,alter_time,userid,shareid  from note n inner join academy_note a " +
            "on n.id = a.note_id and a.academyName = #{academyName}")
    public List<Note> publicAcademyNote(String academyName);
    // 共享院校笔记页笔记模糊查询
    @Select("select id,note_title,note_content,note_time,alter_time,userid,shareid  from note n inner join academy_note a " +
            "on n.id = a.note_id and a.academyName = #{academyName} and n.note_title like #{title}")
    public List<Note> shareAcademySelect(String academyName,String title);
}
