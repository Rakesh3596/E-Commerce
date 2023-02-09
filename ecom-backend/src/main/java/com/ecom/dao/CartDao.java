package com.ecom.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecom.entity.Cart;
import com.ecom.entity.User;

@Repository
public interface CartDao extends CrudRepository<Cart, Integer>{
	
	public List<Cart> findByUser(User user);

}
