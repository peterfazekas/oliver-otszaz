package hu.store.domain.model;

import java.util.Map;
import java.util.stream.Collectors;

public class Cart {

    private final int id;
    private final Map<String, Long>  cart;
    private final int totalValue;

    public Cart(int id, Map<String, Long> cart, int totalValue) {
        this.id = id;
        this.cart = cart;
        this.totalValue = totalValue;
    }

    public Long countItemsInCart() {
        return cart.entrySet().stream()
                .mapToLong(Map.Entry::getValue)
                .sum();
    }

    public boolean contains(String itemName) {
        return cart.containsKey(itemName);
    }

    public String getCartContentInDetails() {
        return cart.entrySet().stream()
                .map(i -> i.getValue() + " " + i.getKey())
                .collect(Collectors.joining("\n"));
    }

    @Override
    public String toString() {
        return id + ": " + totalValue;
    }
}
