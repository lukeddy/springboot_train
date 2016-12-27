package com.yocool.model;

import com.datastax.driver.core.DataType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Getter
@Setter
@Table("student_records")
public class Student {

	@PrimaryKey("student_id")
	private String studentId;

	@Column("join_time")
	@CassandraType(type = DataType.Name.BIGINT)
	private long joinTime;

	@Column("clazz_number")
	private int clazzNumber;

}
