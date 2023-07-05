package com.dtproject.dao.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtproject.dao.CartItemDao;
import com.dtproject.model.CartItem;
import com.dtproject.model.Orders;
@Repository
public class CartItemDaoImpl implements CartItemDao 
{
    @Autowired
    SessionFactory sessionFactory;
	@Override
	public List<CartItem> findByCartId(int cartId)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from CartItem where cartId=:c");
		query.setParameter("c", cartId);
		return query.list();
		
	}
	@Override
	public void deleteCartItem(int cartItemId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("From Orders where cartItem_cartItem_id=:cId");
		query.setParameter("cId", (int)cartItemId);
		Orders orders = (Orders) query.list().get(0);
		session.beginTransaction();
		session.delete(orders);
		session.getTransaction().commit();
		session.close();
		
	}

}
