package com.yocool.service.impl;

import com.yocool.repository.BookRepository;
import com.yocool.model.Book;
import com.yocool.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author tangzq.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void createBook(String name, String isbn, String author, int pages) {
        bookRepository.save(new Book(name,isbn,author,pages));
    }

    @Override
    public void updateCustomerByID(Book book) {
        Book qBook = bookRepository.findOne(book.getId());
        if(null==qBook){
            throw new RuntimeException("书{"+book.getId()+"}不存在");
        }
        qBook.setName(book.getName());
        qBook.setIsbn(book.getIsbn());
        qBook.setAuthor(book.getAuthor());
        qBook.setPages(book.getPages());
        bookRepository.save(qBook);
    }

    /**
     * 分页查找
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public Page<Book> findBookByPager(Integer pageNumber, Integer pageSize) {
        Pageable pageable = new PageRequest(pageNumber, pageSize);
        Page<Book> page = bookRepository.findAll(pageable);
        return page;
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    @Override
    public Book findByID(String bookID) {
        return bookRepository.findOne(bookID);
    }

    @Override
    public void deleteBookByID(String bookID) {
        bookRepository.delete(bookID);
    }
}
