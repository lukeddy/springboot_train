package com.yocool.dao;

import com.yocool.model.Person;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {

    @Query("Select * from person where name=?0")
    public Person findByName(String name);


}
