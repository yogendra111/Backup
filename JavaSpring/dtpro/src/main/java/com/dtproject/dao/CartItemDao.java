package com.dtproject.dao;

import java.util.List;

import com.dtproject.model.CartItem;

public interface CartItemDao {

	List<CartItem> findByCartId(int cartId);

	void deleteCartItem(int cartItemId);

}
