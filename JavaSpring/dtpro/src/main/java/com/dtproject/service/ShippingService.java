package com.dtproject.service;

import java.util.List;

import com.dtproject.model.ShippingAddress;

public interface ShippingService {

	List<ShippingAddress> getAddressByUserName(String getuName);

	ShippingAddress findAddressByShippingId(int sId);

}
