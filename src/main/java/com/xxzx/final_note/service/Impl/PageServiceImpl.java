package com.xxzx.final_note.service.Impl;

import com.xxzx.final_note.dao.PageRepository;
import com.xxzx.final_note.entity.Note;
import com.xxzx.final_note.entity.Page;
import com.xxzx.final_note.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImpl implements PageService {
    @Autowired
    private PageRepository pageRepository;


    @Override
    public List<Note> getNotePage(Integer id, Page page) {
        Integer count = pageRepository.getCount(id);
        System.out.println("总记录数="+count);
        page.setCount(count);
        page.setStartRow(page.getCountSize()*page.getCurrentPage() -3);
        System.out.println("startRow="+page.getStartRow());
        System.out.println("countSize="+page.getCountSize());
        page.setCountPage((count + page.getCountSize()-1)/page.getCountSize());
        System.out.println(pageRepository.getNotePage(id,page.getStartRow(),page.getCountSize()));
        return pageRepository.getNotePage(id,page.getStartRow(),page.getCountSize());
    }

//    @Override
//    public List<Note> getNotePages(Page page) {
//        Integer count = pageRepository.getCount(2);
//        System.out.println("总记录数="+count);
//        page.setCount(count);
//        page.setStartRow(page.getCountSize()*page.getCurrentPage() -3);
//        System.out.println("startRow="+page.getStartRow());
//        page.setCountPage((count + page.getCountSize()-1)/page.getCountSize());
//        return pageRepository.getNotePages(page);
//    }
}
