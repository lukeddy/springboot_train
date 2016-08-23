package com.tangzq;

import com.tangzq.model.Book;
import com.tangzq.service.BookESService;
import com.tangzq.util.CommonUtil;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.highlight.HighlightBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private BookESService bookESService;

    private List<Book> books;

    @Before
    public void init() {
        books = new ArrayList();
        Book b1 = new Book(new Long(111), "isbn111", "Springboot21天精通，学完年薪100W", new Date());
        Book b2 = new Book(new Long(222), "isbn222", "Angular基础教程，掌握拿高薪", new Date());
        Book b3 = new Book(new Long(333), "isbn333", "Git秘籍，学完你就是大牛", new Date());
        Book b4 = new Book(new Long(444), "isbn444", "WEB架构薪全攻略，学完当老板,年薪1000W", new Date());
        Book b5 = new Book(new Long(555), "isbn555", "Linux精通必读，学完轻薪松做架构", new Date());
        Book b6 = new Book(new Long(666), "isbn666", "HTML&CSS&JS大全年秘籍，轻松搞定女票", new Date());
        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        books.add(b5);
        books.add(b6);
        bookESService.resyncBooksToEs(books);
    }

    @Test
    public void testFindOne(){
        Book book=bookESService.findOne(666l);
        Assert.assertNotNull(book);
        System.out.println(book.getBookName()+","+book.getBookNo());
    }

    @Test
    public void testFindAll() {
        Iterable<Book> books = bookESService.findAll();
        Assert.assertNotNull(books);
        for (Book b : books) {
            System.out.println(b.getBookName());
        }
    }

    @Test
    public void testFindAllByPage(){
        Page<Book> pager=bookESService.findAllByPage(10);
        Assert.assertNotNull(pager);
        System.out.println(pager.getTotalPages());
        System.out.println(pager.getTotalElements());
        for(Book b:pager.getContent()){
            System.out.println(b.toString());
        }
    }


    @Test
    public void testSearch(){
        //Page<Book> pager=bookESService.search("秘籍");
        //Page<Book> pager=bookESService.search("1天");
        Page<Book> pager=bookESService.search("年薪");
        Assert.assertNotNull(pager);
        System.out.println(pager.getTotalPages());
        System.out.println(pager.getTotalElements());
        for(Book b:pager.getContent()){
            System.out.println(b.toString());
        }
    }
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    /**
     * 高亮显示关键字，
     * TODO 单个字可以搜索出结果，但是当搜索多个关键字的时候，无法搜索到结果
     */
    @Test
    public void testHighlight(){
        String keyword="全";
        Optional<String> nameOrNumberOrISBN= Optional.ofNullable(keyword);
        NativeSearchQueryBuilder nsq=new NativeSearchQueryBuilder();
        nsq.withQuery(QueryBuilders.termQuery("bookName", nameOrNumberOrISBN.get()));
        SearchQuery searchQuery=nsq.withHighlightFields(new HighlightBuilder.Field("bookName")).build();

        Page<Book> pager = elasticsearchTemplate.queryForPage(searchQuery, Book.class, new SearchResultMapper() {
            @Override
            public <T> Page<T> mapResults(SearchResponse response, Class<T> aClass, Pageable pageable) {
                List<Book> chunk = new ArrayList();
                for (SearchHit searchHit : response.getHits()) {
                    if (searchHit==null) {
                        continue;
                    }
                    Book book = new Book();
                    book.setBookNo(Long.parseLong(searchHit.getId()));
                    book.setBookIsbn((String)searchHit.getSource().get("bookIsbn"));
                    book.setBookName((String)searchHit.getSource().get("bookName"));
                    book.setCreateAt(new Date((long)searchHit.getSource().get("createAt")));
                    if(searchHit.getHighlightFields().get("bookName")!=null){
                        System.out.println("高亮内容："+searchHit.getHighlightFields().get("bookName").fragments()[0].toString());
                    }
                    chunk.add(book);
                }
                if (chunk.size() > 0) {
                    return new PageImpl(chunk);
                }
                return null;
            }
        });
        Assert.assertNotNull(pager);
        System.out.println(pager.getTotalPages());
        System.out.println(pager.getTotalElements());
        for(Book b:pager.getContent()){
            System.out.println(b.toString());
        }

    }
}
