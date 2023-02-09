package com.ecom.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.configuration.JwtRequestFilter;
import com.ecom.dao.CartDao;
import com.ecom.dao.ProductDao;
import com.ecom.dao.UserDao;
import com.ecom.entity.Cart;
import com.ecom.entity.Product;
import com.ecom.entity.User;

@Service
public class CartService {
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private UserDao userDao;
	
	public void deleteCartItem(Integer cartId) {
		cartDao.deleteById(cartId);
	}
	
	public Cart addToCart(Integer productId) {
		
		Product product = productDao.findById(productId).get();
		
		String username = JwtRequestFilter.CURRENT_USER;
		
		User user = null;
		
		if(username != null) {
			user = userDao.findById(username).get();
			
		}
		
		List<Cart> cartList = cartDao.findByUser(user);
		List<Cart> filteredList = cartList.stream().filter(x -> x.getProduct().getProductId() == productId).collect(Collectors.toList());
		
		if(filteredList.size() > 0) {
			return null;
		}
		
		
		if(product != null && user != null) {
			Cart cart = new Cart(product, user);
			return cartDao.save(cart);
		}
		return null;
	}
	
	public List<Cart> getCartDetails(){
		String username = JwtRequestFilter.CURRENT_USER;
		User user = userDao.findById(username).get();
		return cartDao.findByUser(user);
		
	}
	
	

}
