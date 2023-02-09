package com.ecom.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	private String productName;
	@Column(length = 1000)
	private String productDescription;
	private Double productDiscountedPrice;
	private Double productActualPrice;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade =CascadeType.ALL)
	@JoinTable(name = "product_images",
	joinColumns = {
			@JoinColumn(name = "product_id")
	},
	inverseJoinColumns = {
			@JoinColumn(name = "image_id")
	})
	private Set<ImageModel> productImages;
	
	
	
	public Set<ImageModel> getProductImages() {
		return productImages;
	}

	public void setProductImages(Set<ImageModel> productImages) {
		this.productImages = productImages;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Double getProductDiscountedPrice() {
		return productDiscountedPrice;
	}

	public void setProductDiscountedPrice(Double productDiscountedPrice) {
		this.productDiscountedPrice = productDiscountedPrice;
	}

	public Double getProductActualPrice() {
		return productActualPrice;
	}

	public void setProductActualPrice(Double productActualPrice) {
		this.productActualPrice = productActualPrice;
	}

	public Product(Integer productId, String productName, String productDescription, Double productDiscountedPrice,
			Double productActualPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productDiscountedPrice = productDiscountedPrice;
		this.productActualPrice = productActualPrice;
	}
	
	
	
	

}
