package com.dtproject.dao;

import java.util.List;

import com.dtproject.model.ShippingAddress;

public interface ShippingDao {

	List<ShippingAddress> getAddressByUserName(String getuName);

	ShippingAddress findAddressByShippingId(int sId);

}
