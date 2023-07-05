package com.dtproject.service;

import java.util.List;

import com.dtproject.model.CartItem;

public interface CartItemService {

	List<CartItem> findByCartId(int cartId);

	void deleteCartItem(int cartItemId);

}
