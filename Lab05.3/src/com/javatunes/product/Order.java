/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import com.javatunes.billing.Location;
import com.javatunes.billing.TaxCalculator;
import com.javatunes.billing.TaxCalculatorFactory;
import java.util.Collection;

public class Order {
    private final String id;
    private final Location location;
    private double cartTotal;

    public Order(String id, Location location) {
        this.id = id;
        this.location = location;
    }

    public double getTax() {
        // fetch the appropriate TaxCalculator from the factory
        TaxCalculator calc = TaxCalculatorFactory.getTaxCalculator(getLocation());

        // delegate to it for the actual work
        return calc.taxAmount(getCartTotal());
    }

    /**
     * DONE:
     * get the items from the cart and iterate over them, print each item's product code
     * get cart total and print
     */
    public void processCart(ShoppingCart<? extends Product> cart) {
        System.out.println("Order: " + getId() + " contains the following:");

        Collection<? extends Product> cartItems = cart.allItems();
        for (Product product : cartItems) {
            System.out.println(product.getCode());
        }

        // assign to field 'cartTotal' the total amount of the cart
        cartTotal = cart.total();

        System.out.println("Order Total: " + cartTotal);
    }

    public String getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public double getCartTotal() {
        return cartTotal;
    }
}