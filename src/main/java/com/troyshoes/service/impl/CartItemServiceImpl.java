package com.troyshoes.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.troyshoes.domain.CartItem;
import com.troyshoes.domain.ShoppingCart;
import com.troyshoes.repository.CartItemRepository;
import com.troyshoes.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService{
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart){
		return cartItemRepository.findByShoppingCart(shoppingCart);
	}
	
	public CartItem updateCartItem(CartItem cartItem) {
		BigDecimal bigDecimal = new BigDecimal(cartItem.getShoes().getOurPrice()).multiply(new BigDecimal(cartItem.getQuantity()));
		
		bigDecimal = bigDecimal.setScale(2, RoundingMode.CEILING);
		cartItem.setSubtotal(bigDecimal);
		
		cartItemRepository.save(cartItem);
		
		return cartItem;
	}
}
