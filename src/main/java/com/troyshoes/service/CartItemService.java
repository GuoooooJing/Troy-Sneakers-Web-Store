package com.troyshoes.service;

import java.util.List;

import com.troyshoes.domain.CartItem;
import com.troyshoes.domain.ShoppingCart;

public interface CartItemService {
	
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
	CartItem updateCartItem(CartItem cartItem);
}
