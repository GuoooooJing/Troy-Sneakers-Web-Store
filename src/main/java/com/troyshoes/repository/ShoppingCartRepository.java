package com.troyshoes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.troyshoes.domain.CartItem;
import com.troyshoes.domain.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long>{
	
}
