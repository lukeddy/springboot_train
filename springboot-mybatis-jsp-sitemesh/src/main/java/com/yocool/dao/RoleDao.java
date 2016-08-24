package com.yocool.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yocool.entity.Role;


/**
 * 用户DAO类
 */
@Repository
public interface RoleDao {

	public Role getById(Long id);
	
	public List<Role> getAll();
	
	public int insert(Role role);
	
	public int update(Role role);
	
	public void delete(Long id);
}
