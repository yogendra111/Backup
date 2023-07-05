package com.dtproject.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtproject.dao.ShippingDao;
import com.dtproject.model.ShippingAddress;
import com.dtproject.service.ShippingService;
@Service
public class ShippingServiceImpl implements ShippingService
{

	@Autowired 
	private ShippingDao shippingDao;
	@Override
	public List<ShippingAddress> getAddressByUserName(String getuName) 
	{
		List<ShippingAddress> shippingaddress=shippingDao.getAddressByUserName(getuName);
		return shippingaddress;
	}
	@Override
	public ShippingAddress findAddressByShippingId(int sId) 
	{
		ShippingAddress shippingAddress=shippingDao.findAddressByShippingId(sId);
		return null;
	}

}
