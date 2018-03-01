package com.yocool.service;

import com.yocool.model.Book;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Author tangzq.
 */
public interface BookService {
    public void createBook(String name, String isbn, String author, int pages);
    public void updateCustomerByID(Book book);
    public Page<Book> findBookByPager(Integer pageNumber, Integer pageSize);
    public List<Book> findByAuthor(String author);
    public Book findByID(String bookID);
    public void deleteBookByID(String bookID);
}
