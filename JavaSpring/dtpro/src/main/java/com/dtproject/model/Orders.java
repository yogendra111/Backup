package com.dtproject.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
@Entity
@Component
public class Orders implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
private int orderId;
	
	@OneToOne(cascade=CascadeType.ALL,targetEntity=ShippingAddress.class)
	private ShippingAddress sAddress;
	
	@Transient
	private List<ShippingAddress> shippingAddressList;
	
	@OneToOne(cascade=CascadeType.ALL,targetEntity=BillingAddress.class)
	private BillingAddress bAddress;
	
	@Transient
	private Product product;
	
	@OneToOne(cascade=CascadeType.ALL,targetEntity=CartItem.class)
	private CartItem cartItem;
	
	
	@OneToOne(cascade=CascadeType.ALL,targetEntity=Payment.class)
	private Payment payment;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public ShippingAddress getsAddress() {
		return sAddress;
	}

	public void setsAddress(ShippingAddress sAddress) {
		this.sAddress = sAddress;
	}

	public List<ShippingAddress> getShippingAddressList() {
		return shippingAddressList;
	}

	public void setShippingAddressList(List<ShippingAddress> shippingAddressList) {
		this.shippingAddressList = shippingAddressList;
	}

	public BillingAddress getbAddress() {
		return bAddress;
	}

	public void setbAddress(BillingAddress bAddress) {
		this.bAddress = bAddress;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public CartItem getCartItem() {
		return cartItem;
	}

	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
}
