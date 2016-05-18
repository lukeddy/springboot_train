package com.yocool.repo;

import com.yocool.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Book文档操作类，继承MongoRepository
 */
@Repository
public interface BookRepository extends MongoRepository<Book,String> {

}
