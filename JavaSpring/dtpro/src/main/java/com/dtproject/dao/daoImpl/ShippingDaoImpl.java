package com.dtproject.dao.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtproject.dao.ShippingDao;
import com.dtproject.model.ShippingAddress;
@Repository
public class ShippingDaoImpl implements ShippingDao
{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<ShippingAddress> getAddressByUserName(String getuName) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from ShippingAddress where username=:u");
		query.setParameter("u", getuName);
		return query.list();
		
	}

	@Override
	public ShippingAddress findAddressByShippingId(int sId)
	{
		Session session=sessionFactory.openSession();
		return (ShippingAddress) session.get(ShippingAddress.class, sId);
		 
		
	}

}
