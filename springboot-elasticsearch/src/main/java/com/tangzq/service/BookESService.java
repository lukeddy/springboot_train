package com.tangzq.service;

import com.tangzq.model.Book;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 书籍ES接口类
 */
public interface BookESService {

    /**
     * 重新同步书籍数据到ES 這個操作很耗性能
     * @param bookList
     */
    void resyncBooksToEs(List<Book> bookList);

    /**
     * 同步一本書籍到ES
     * @param b
     */
    void syncOne(Book b);

    /**
     * 通过书籍id找一本书
     * @param bookNo
     * @return
     */
    Book findOne(Long bookNo);

    /**
     * 查詢所有
     * @return
     */
    Iterable<Book> findAll();

    /**
     * 刪除指定書籍的索引
     * @param bookNo
     */
    void deleteByBookNo(Long bookNo);

    /**
     * 刪除所有索引
     */
    void deleteAll();


    /**
     * 分页查找
     * @return
     */
    Page<Book> findAllByPage(int pageSize);

    /**
     * 搜索
     * @param nameOrNumberOrISBN  书名或书的编号或isbn等
     * @return
     */
    Page<Book> search(String nameOrNumberOrISBN);
}
