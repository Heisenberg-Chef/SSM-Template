package com.qi.dao;

import com.qi.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    // 增
    int addBook(Books books);
    // 删
    int deleteBookById(@Param("bookId") int id);
    // 改
    int updateBook(Books books);
    // 查
    Books queryBookById(int id);
    // 查全部
    List<Books> queryAllBook();
}
