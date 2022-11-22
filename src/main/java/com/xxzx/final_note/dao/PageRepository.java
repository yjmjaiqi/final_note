package com.xxzx.final_note.dao;

import com.xxzx.final_note.entity.Note;
import com.xxzx.final_note.entity.Page;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageRepository {
    // 查询总记录数
    @Select("select count(*) from note where userid = #{id}")
    public Integer getCount(Integer id);

    // 查询所有数据  笔记首页数据渲染
    @Select("select * from note where userid = #{id} order by id desc limit #{startRow},#{countSize}")
    public List<Note> getNotePage(Integer id, Integer startRow, Integer countSize);

    //    @Select("select * from note order by id desc limit #{startRow},#{countSize}")
//    public List<Note> getNotePages(Page page);
    // 模糊查询总记录数
    @Select("select count(*) from note where userid = #{id} and note_title like #{title}")
    public Integer selectCount(Integer id,String title);

    // 模糊数据查询
    @Select("select * from note where note_title like #{title} and userid = #{id} order by id desc limit #{startRow},#{countSize}")
    public List<Note> selectNotePage(String title,Integer id, Integer startRow, Integer countSize);
}
