package com.tangzq.service.impl;

import com.tangzq.model.Customer;
import com.tangzq.service.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 接口实现类
 */
@Service
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void insert(Customer user) {
        String sql = "INSERT INTO customers(first_name, last_name) VALUES (?,?)";
        jdbcTemplate.update(sql,new Object[] {user.getFirstName(),user.getLastName()});
    }

    @Override
    public List<Customer> findAll() {
        String sql="select * from customers";
        return jdbcTemplate.query(sql, new Object[]{}, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs, int i) throws SQLException {
                Customer user  = new Customer(rs.getInt("id"),rs.getString("first_name"),rs.getString("last_name"));
                return user;
            }
        });
    }

    @Override
    public void update(Customer user) {
        String sql = "UPDATE customers set first_name=?,last_name=? where id = ?";
        jdbcTemplate.update(sql, ps -> {
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setLong(3, user.getId());
        });
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from customers where id=?", new Object[]{id},new int[]{java.sql.Types.INTEGER});
    }

    @Override
    public boolean isExist(int id) {
        Integer cnt = jdbcTemplate.queryForObject(
                "SELECT count(*) FROM customers WHERE id = ?", Integer.class, id);
        return cnt != null && cnt > 0;
    }
}
