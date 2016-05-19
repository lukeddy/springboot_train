package com.yocool.dao;

import com.yocool.model.Person;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {

    /**
     * 这里需要注意的是非主键字段不用直接用来做过滤调价的，如果非要使用非主键字段做为查询条件。需要将其修改为主键字段，或者建立二级索引
     * @param name
     * @return
     */
    @Query("Select * from person where name=?0")
    public Person findByName(String name);


}
