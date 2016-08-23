package com.tangzq.repository;

import com.tangzq.model.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 书籍保存到ES接口
 */
public interface BookESRepository extends ElasticsearchRepository<Book, Long> {
}
