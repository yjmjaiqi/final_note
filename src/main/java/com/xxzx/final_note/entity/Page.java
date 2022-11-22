package com.xxzx.final_note.entity;
import lombok.Data;

@Data
public class Page {
    // 第一页
    private Integer firstPage = 1;
    // 当前页
    private Integer currentPage = 1;
    // 每页记录数
    private Integer countSize = 3;
    // 总页数
    private Integer countPage;
    // 总记录数
    private Integer count;
    // 开始行号
    private Integer startRow;
}
