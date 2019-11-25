package hu.store.domain.service;

import hu.store.domain.model.Cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataParser {

    private int id = 0;

    List<Cart> parse(List<String> lines) {
        List<Cart> carts = new ArrayList<>();
        List<String> items = new ArrayList<>();
        for (var line : lines) {
            if ("F".equals(line)) {
                carts.add(createCart(items));
                items = new ArrayList<>();
            } else {
                items.add(line);
            }
        }
        return carts;
    }

    private Cart createCart(List<String> cartItems) {
        Map<String, Long> goodsMap = createGoodsMap(cartItems);
        int totalValue = calculateTotalValue(goodsMap);
        return new Cart(++id, goodsMap, totalValue);
    }

    private int calculateTotalValue(Map<String, Long> goodsMap) {
        return goodsMap.values().stream()
                .mapToInt(ValueCalculator::calculate)
                .sum();
    }

    private Map<String, Long> createGoodsMap(List<String> cartItems) {
        return cartItems.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
