package com.yocool.dao;

import com.yocool.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Author tangzq.
 */
public interface BookRepository extends PagingAndSortingRepository<Book,String> {
    public Book findByName(String name);
    public List<Book> findByAuthor(String author);

}
