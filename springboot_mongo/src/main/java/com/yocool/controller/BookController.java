package com.yocool.controller;

import com.yocool.model.Book;
import com.yocool.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 控制器
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> createBook(@RequestBody Map<String, Object> bookMap){
        Book book = new Book(bookMap.get("name").toString(),
                bookMap.get("isbn").toString(),
                bookMap.get("author").toString(),
                Integer.parseInt(bookMap.get("pages").toString()));

        bookRepository.save(book);
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("message", "Book created successfully");
        response.put("book", book);
        return response;
    }

    @RequestMapping(method = RequestMethod.GET, value="/{bookId}")
    public Book getBookDetails(@PathVariable("bookId") String bookId){
        return bookRepository.findOne(bookId);
    }
}
