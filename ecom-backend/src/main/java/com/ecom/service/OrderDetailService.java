package com.ecom.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.configuration.JwtRequestFilter;
import com.ecom.dao.CartDao;
import com.ecom.dao.OrderDetailDao;
import com.ecom.dao.ProductDao;
import com.ecom.dao.UserDao;
import com.ecom.entity.Cart;
import com.ecom.entity.OrderDetail;
import com.ecom.entity.OrderInput;
import com.ecom.entity.OrderProductQuantity;
import com.ecom.entity.Product;
import com.ecom.entity.User;

@Service
public class OrderDetailService {
	
	private static final String ORDER_PLACED = "Placed";  
	
	@Autowired
	private OrderDetailDao orderDetailDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CartDao cartDao;
	
	public List<OrderDetail> getAllOrderDetails(){
		List<OrderDetail> orderDetails = new ArrayList<>();
		orderDetailDao.findAll().forEach(e -> orderDetails.add(e));
		
		return orderDetails;
	}
	
	public List<OrderDetail> getOrderDetails() {
		String currentUser = JwtRequestFilter.CURRENT_USER;
		User user = userDao.findById(currentUser).get();
		
		return orderDetailDao.findByUser(user);
	}
	
	public void placeOrder(OrderInput orderInput, boolean isSingleProductCheckout) {
		List<OrderProductQuantity> productQuantityList = orderInput.getOrderProductQuantityList();
		
		for(OrderProductQuantity o: productQuantityList) {
			Product product = productDao.findById(o.getProductId()).get();
			
			String currentUser = JwtRequestFilter.CURRENT_USER;
			User user= userDao.findById(currentUser).get();
			
			OrderDetail orderDetail = new OrderDetail(
					orderInput.getFullName(),
					orderInput.getFullAddress(),
					orderInput.getContactNumber(),
					orderInput.getAlternateContactNumber(),
					ORDER_PLACED,
					product.getProductDiscountedPrice()*o.getQuantity(),
					product,
					user);
			
			if(!isSingleProductCheckout) {
				List<Cart> carts= cartDao.findByUser(user);
				carts.stream().forEach(x -> cartDao.deleteById(x.getCartId()));			
				
			}
			orderDetailDao.save(orderDetail);
		}
	}
	
	

}
