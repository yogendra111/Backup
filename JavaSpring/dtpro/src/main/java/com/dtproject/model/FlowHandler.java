package com.dtproject.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;

import com.dtproject.service.CartItemService;
import com.dtproject.service.CartService;
import com.dtproject.service.ProductService;
import com.dtproject.service.ShippingService;
import com.dtproject.service.UserService;


@Component
public class FlowHandler 
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private User user; 
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private ShippingService shippingService;
	
	@Autowired
	private CartService cartService;
	
	private List<ShippingAddress> addressList;
	
	public void initOrders()
	{
		System.out.println("init orders");
		String userName=SecurityContextHolder.getContext().getAuthentication().getName();
		user=userService.findUserByName(userName);
		System.out.println(user.getuName()+" "+user.getCartId());
	}
	public Orders addToCart(int pid,int quantity,Orders order)
	{
	    System.out.println("add to cart");
	    order.setsAddress(new ShippingAddress());
	    
		Product product=productService.findProductById(pid);
		order.setProduct(product);
		//System.out.println(product.getpId());
		List<CartItem> cartItem=cartItemService.findByCartId(user.getCartId());
		CartItem cart=new CartItem();
		int i=0;
		if(!cartItem.isEmpty())
		{
			for(CartItem citem:cartItem)
			{
				if(citem.getProductId()==pid)//if there is same product already in the cart which user want to buy;
				{
					cart.setQuantity(citem.getQuantity()+quantity);
					cart.setCartId(citem.getCartId());
					cart.setProductId(citem.getProductId());
					cart.setCartItem_id(citem.getCartItem_id());
					cart.setProductprice(cart.getQuantity()*product.getpPrice());
//					cart.setBillingAddress(citem.getBillingAddress());
//					cart.setShippingAddress(citem.getShippingAddress());
				i=1;
				}
				
			}
		}
		if(i==0)
		{
			cart.setProductId(product.getpId());
			cart.setCartId(user.getCartId());
			cart.setProductprice(product.getpPrice());
			cart.setQuantity(quantity);
			
			
		}
		order.setCartItem(cart);
		
		return order;
		
	}
	 public String checkShippingAddress()
	 {
		 List<ShippingAddress> shippingAddress=shippingService.getAddressByUserName(user.getuName());
        if(shippingAddress.isEmpty())
        {
        
        	System.out.println("address list is empty");
        	return "empty";
        }
        else
        {
        	addressList=shippingAddress;
        	return "available";
        }
		 
	 }
	 
	 public Orders attachAddress(Orders orders,RequestContext context)
	 {
		 addressList=new ArrayList<ShippingAddress>();
		 ShippingAddress shippingAddress=orders.getsAddress();
		 shippingAddress.setUsername(user.getuName());
		 addressList.add(shippingAddress);
		 String s=context.getRequestParameters().get("billingAddress");
		 if(!s.equals(null))
		 {
			 
			 BillingAddress billingAddress=new BillingAddress();
			 billingAddress.setAddress(shippingAddress.getAddress());
			 billingAddress.setCity(shippingAddress.getCity());
			 billingAddress.setPincode(shippingAddress.getPincode());
			 billingAddress.setState(shippingAddress.getState());
			 billingAddress.setUsername(shippingAddress.getUsername());
			 
			 orders.setbAddress(billingAddress);
			 
		 }
		 
		return orders;
		 
	 }
	 public Orders getAddress(Orders orders)
	 {
		 orders.setShippingAddressList(addressList);
		return orders;
		 
	 }
	 public Orders sAddress(Orders order)
	 {
		 int sId=order.getsAddress().getShippingId();
		 System.out.println(sId);
		 ShippingAddress shippingAddress=null;
		 for(ShippingAddress sa:addressList)
		 {
			 if(sa.getShippingId()==sId)
			 {
				shippingAddress=sa; 
			 }
		 }
		 order.setsAddress(shippingAddress);
		 BillingAddress billingAddress=new BillingAddress();
		 billingAddress.setAddress(shippingAddress.getAddress());
		 billingAddress.setCity(shippingAddress.getCity());
		 billingAddress.setPincode(shippingAddress.getPincode());
		 billingAddress.setState(shippingAddress.getState());
		 billingAddress.setUsername(shippingAddress.getUsername());
		 
		 order.setbAddress(billingAddress);
		Payment payment=new Payment();
		order.setPayment(payment);
		 return order;
		
		 
	 }
	 
	 public String saveOrder(Orders order)
	 {
		cartService.saveOrder(order,user.getuId());
		return "success";
	 }
}
