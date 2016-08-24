package com.yocool.dao;

import java.util.List;

import com.yocool.entity.User;
import org.springframework.stereotype.Repository;

/**
 * 用户DAO类
 */
@Repository
public interface UserDao {
	
	public User getById(Long id);

	public List<User> getAll();

	public User findByLoginName(String name);

	public int insert(User user);

	public int update(User user);

	public void delete(Long id);
}
