package com.qi.pojo;

import lombok.Data;

@Data
public class Books {
    /**
     * 尽量保证字符相同
     */
    private int bookID;
    private String bookName;
    private int bookCounts;
    private String detail;
}
