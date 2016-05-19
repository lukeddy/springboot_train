package com.yocool.dao;

import com.yocool.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Author tangzq.
 */
public interface PersonPagerRepository extends PagingAndSortingRepository<Person,String> {

}
