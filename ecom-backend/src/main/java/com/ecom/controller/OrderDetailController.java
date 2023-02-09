package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.dao.CartDao;
import com.ecom.entity.OrderDetail;
import com.ecom.entity.OrderInput;
import com.ecom.service.OrderDetailService;

@RestController
public class OrderDetailController {
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	
	
	@PreAuthorize("hasRole('User')")
	@PostMapping({"/placeOrder/{isSingleProductCheckout}"})
	public void placeOrder(@PathVariable(name= "isSingleProductCheckout") boolean isSingleProductCheckout, @RequestBody OrderInput orderInput) {
		orderDetailService.placeOrder(orderInput, isSingleProductCheckout);
		
	}
	
	@PreAuthorize("hasRole('User')")
	@GetMapping({"/getOrderDetails"})
	public List<OrderDetail> getOrderDetails() {
		return orderDetailService.getOrderDetails();
	}
	
	@PreAuthorize("hasRole('Admin')")
	@GetMapping({"/getAllOrderDetails"})
	public List<OrderDetail> getAllOrderDetails() {
		return orderDetailService.getAllOrderDetails();
	}

}
