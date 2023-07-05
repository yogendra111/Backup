package com.dtproject.dao.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtproject.dao.UserDao;
import com.dtproject.model.Cart;
import com.dtproject.model.User;
@Repository
public class UserDaoImpl implements UserDao
{
	@Autowired
	SessionFactory sf;

	@Override
	public void saveUser(User user) 
	{
		Session session=sf.openSession();
		session.beginTransaction();
		user.setEnabled(true);
		Cart cart=new Cart();
		session.save(user);
		cart.setUserId(user.getuId());
		session.save(cart);
		user.setCartId(cart.getCartId());
		session.update(user);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public User findUserByname(String userName) 
	{
		Session session=sf.openSession();
		Query query=session.createQuery("From User where uName=:n");
		query.setParameter("n", userName);
		User user=(User)query.list().get(0);
		return user;
	}
}
