package com.peisia.c.catcafe;

public class Order {
	public Product selectedProducts;
	public int optionHotCold=0;
	
	public Order(Product selectedProducts) {
		this.selectedProducts=selectedProducts;
	}
	public Order(Product selectedProducts, int optionHotCold) {
		this.selectedProducts=selectedProducts;
		this.optionHotCold=optionHotCold;
	}
	
}
 