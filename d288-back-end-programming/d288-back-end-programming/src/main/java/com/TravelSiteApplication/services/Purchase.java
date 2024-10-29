package com.TravelSiteApplication.services;

import com.TravelSiteApplication.entity.Cart;
import com.TravelSiteApplication.entity.CartItem;
import com.TravelSiteApplication.entity.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Purchase {
    private Cart cart;
    private Customer customer;
    private Set<CartItem> cartItems;

}
