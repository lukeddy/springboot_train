package com.tangzq.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;


/**
 * ES模型类
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(type ="books", indexName = "book")
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long bookNo;

	@Field(type = FieldType.String, index = FieldIndex.not_analyzed)
	private String bookIsbn;

	@Field(type = FieldType.String, index = FieldIndex.analyzed, analyzer = "smartcn")
	private String bookName;
	
	@Field(type = FieldType.Date, index = FieldIndex.not_analyzed)
	private Date createAt;

}