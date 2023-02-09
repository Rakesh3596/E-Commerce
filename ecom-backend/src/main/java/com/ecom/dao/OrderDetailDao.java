package com.ecom.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecom.entity.OrderDetail;
import com.ecom.entity.User;

@Repository
public interface OrderDetailDao extends CrudRepository<OrderDetail, Integer>{
	
	public List<OrderDetail> findByUser(User user);

}
