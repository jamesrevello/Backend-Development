package com.TravelSiteApplication.services;

import com.TravelSiteApplication.dao.CartRepository;
import com.TravelSiteApplication.entity.Cart;
import com.TravelSiteApplication.entity.CartItem;
import com.TravelSiteApplication.entity.Customer;
import com.TravelSiteApplication.entity.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    private CartRepository cartRepository;

    public CheckoutServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Cart cart = purchase.getCart();

        Customer customer = purchase.getCustomer();

        String orderTrackingNumber = generateTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        Set<CartItem> cartItem = purchase.getCartItems();
        cartItem.forEach(item -> cart.add(item));

        cart.setCartItems(purchase.getCartItems());
        cart.setCustomer(purchase.getCustomer());

        cart.setStatus(StatusType.ordered);

        cartRepository.save(cart);

        return new PurchaseResponse(orderTrackingNumber);
    }

    public String generateTrackingNumber() {
        return UUID.randomUUID().toString();
    }


}
