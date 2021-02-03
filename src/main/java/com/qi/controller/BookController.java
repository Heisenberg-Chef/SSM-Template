package com.qi.controller;

import com.qi.pojo.Books;
import com.qi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    // controller 调 service 层
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    // 查询全部的书籍,并且返回到一个数据展示页面
    @RequestMapping("/allBook")
    public String list(Model model)
    {
        List<Books> books = bookService.queryAllBook();
        model.addAttribute("list",books);
        return "allBook";
    }

    // 添加书籍
    @RequestMapping("/toAddBook")
    public String toAddPaper()
    {
        // 直接进行跳转
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addPaper(Books books)
    {
        System.out.println(books);
        bookService.addBook(books);
        // 重定位到索引所有书籍
        return "redirect:/book/allBook";
    }

    // 修改书籍
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id,Model model)
    {
        Books books = bookService.queryBookById(id);
        System.out.println(books);
        model.addAttribute("QBooks",books);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Model model,Books book)
    {
        System.out.println(book);
        bookService.updateBook(book);
        Books books = bookService.queryBookById(book.getBookID());
        model.addAttribute("books",books);
        //  返回到所有书籍的页面
        return "redirect:/book/allBook";
    }

    // 删除书籍
    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }
}
