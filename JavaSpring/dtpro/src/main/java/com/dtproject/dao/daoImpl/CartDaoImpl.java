package com.dtproject.dao.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtproject.dao.CartDao;
import com.dtproject.model.BillingAddress;
import com.dtproject.model.Cart;
import com.dtproject.model.CartItem;
import com.dtproject.model.Orders;
import com.dtproject.model.Product;
import com.dtproject.model.ShippingAddress;
@Repository
public class CartDaoImpl implements CartDao
{
@Autowired
private SessionFactory sessionFactory;
	@Override
	public Cart findCartByCartId(int cartId) 
	{
		Session session=sessionFactory.openSession();
		Cart cart=(Cart) session.get(Cart.class, cartId);
		return cart;
	}
	@Override
	public void saveOrder(Orders order,int uId) 
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("From Cart where userId=:u");
		query.setParameter("u", uId);
		Cart cart=(Cart) query.list().get(0);
		cart.setGrandTotal(cart.getGrandTotal()+order.getCartItem().getProductprice());
		cart.setTotalItems(cart.getTotalItems()+1);
		
		session.update(cart);
		int q=order.getCartItem().getQuantity();
		Product product=order.getProduct();
		product.setpQuantity(product.getpQuantity()-q);
		
		BillingAddress bA= order.getbAddress();
		ShippingAddress sA=order.getsAddress();
		int bId=(int) session.save(bA);
		int sId=(int) session.save(sA);
		CartItem cI=order.getCartItem();
		cI.setBillingAddress(bId);
		cI.setShippingAddress(sId);
		order.setCartItem(cI);
		order.setbAddress(bA);
		order.setsAddress(sA);
		
		session.saveOrUpdate(order);
		session.update(product);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void updateCartItem(int cartItemId, int q) 
	{
		Session session = sessionFactory.openSession();
		CartItem cartItem = (CartItem) session.get(CartItem.class, cartItemId);
		Product product =(Product) session.get(Product.class, cartItem.getProductId());
		session.beginTransaction();
		cartItem.setQuantity(q);
		cartItem.setProductprice(cartItem.getQuantity()*product.getpPrice());
		session.update(cartItem);
		session.getTransaction().commit();
		session.close();
		System.out.println("successfully updated cart.................");
	
		
	}

}
