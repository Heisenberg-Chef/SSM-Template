package com.qi.service;

import com.qi.dao.BookMapper;
import com.qi.pojo.Books;
import lombok.Data;

import java.util.List;
@Data
public class BookServiceImpl implements BookService{
    /**
     * 我们的service业务层调DAO层,组合dao
     */
    private BookMapper bookMapper;

    /**
     *  下面业务与层的代码直接就调用dao就行了
     */

    @Override
    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }
}
