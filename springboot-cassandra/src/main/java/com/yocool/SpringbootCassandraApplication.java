package com.yocool;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.cassandra.core.keyspace.CreateIndexSpecification;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.cassandra.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.CassandraAdminTemplate;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraPersistentEntity;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.Indexed;

import java.lang.reflect.Field;

@SpringBootApplication(scanBasePackages = "com.yocool")

public class SpringbootCassandraApplication implements CommandLineRunner,ApplicationListener<ContextRefreshedEvent> {

	private static final Logger logger = LoggerFactory.getLogger(SpringbootCassandraApplication.class);

	@Autowired
	private CassandraProperties cassandraProperties;

	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCassandraApplication.class, args);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent context) {
		applicationContext=context.getApplicationContext();
	}


	@Override
	public void run(String... strings) throws Exception {
		logger.info("开始初始化Cassandra表和索引.。。。");
		createCassandraTable();
		logger.info("初始化Cassandra表和索引完成。。。");
	}

	protected void createCassandraTable() {
		Cluster cluster = Cluster.builder().addContactPoints(cassandraProperties.getContactPoints()).build();
		Session session = cluster.connect(cassandraProperties.getKeyspaceName());
		CassandraAdminTemplate adminTemplate =new CassandraAdminTemplate(session,new MappingCassandraConverter());
		CassandraMappingContext mappingContext = applicationContext.getBean(CassandraMappingContext.class);
		mappingContext.getPersistentEntities().forEach(item -> {
			Class<?> entityClass = item.getType();
			logger.debug("Tring create cassandra table {} for entity class {}, maybe no effect!",
					item.getTableName().toCql(), entityClass.getName());
			adminTemplate.createTable(true, item.getTableName(), entityClass, null);
			createCassandraTableIndex(adminTemplate, item, entityClass);
		});
	}

	protected void createCassandraTableIndex(CassandraAdminTemplate adminTemplate, CassandraPersistentEntity<?> entity,
											 Class<?> entityClass) {
		CreateIndexSpecification createIndex = null;
		for (Field field : entityClass.getDeclaredFields()) {
			if (field.isAnnotationPresent(Indexed.class)) {
				String columnName = field.getName();
				if (field.isAnnotationPresent(Column.class)) {
					columnName = field.getAnnotation(Column.class).value();
				}
				createIndex = CreateIndexSpecification.createIndex("index_" + columnName).columnName(columnName)
						.tableName(entity.getTableName()).ifNotExists();
				logger.debug("Create index for column {} in {} table!", columnName, entity.getTableName());
				adminTemplate.execute(createIndex);
			}
		}
	}

}
