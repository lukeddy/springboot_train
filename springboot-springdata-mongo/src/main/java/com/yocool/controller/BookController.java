package com.yocool.controller;

import com.yocool.model.Book;
import com.yocool.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author tangzq.
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;


    @RequestMapping("/list")
    public Page<Book> bookList(
            @RequestParam(value = "pNum",required = false,defaultValue = "1")Integer pageNumber,
            @RequestParam(value = "pSize",required = false,defaultValue = "10")Integer pageSize
    ){
        Page<Book> pager=bookService.findBookByPager(pageNumber,pageSize);
        return pager;
    }

    /**
     * 根据作者查找
     * @param author
     * @return
     */
    @RequestMapping("/q")
    public List<Book> search(@RequestParam(value="a")String author){
        return bookService.findByAuthor(author);
    }

}
