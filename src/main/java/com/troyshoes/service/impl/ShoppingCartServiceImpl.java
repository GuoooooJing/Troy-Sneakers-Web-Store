package com.troyshoes.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.troyshoes.domain.CartItem;
import com.troyshoes.domain.ShoppingCart;
import com.troyshoes.repository.ShoppingCartRepository;
import com.troyshoes.service.CartItemService;
import com.troyshoes.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart) {
		BigDecimal cartTotal = new BigDecimal(0);
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		for (CartItem cartItem: cartItemList) {
			if(cartItem.getShoes().getInStockNumber() > 0) {
				cartItemService.updateCartItem(cartItem);
				cartTotal = cartTotal.add(cartItem.getSubtotal());
			}
		}
		
		shoppingCart.setGrandTotal(cartTotal);
		shoppingCartRepository.save(shoppingCart);
		return shoppingCart;
	}

}
