package com.yocool.repository;

import com.yocool.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Author tangzq.
 */
public interface BookRepository extends PagingAndSortingRepository<Book,String> {
     Book findByName(String name);
     List<Book> findByAuthor(String author);
}
