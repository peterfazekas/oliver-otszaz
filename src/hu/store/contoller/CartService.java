package hu.store.contoller;

import hu.store.domain.model.Cart;

import java.util.List;
import java.util.stream.Collectors;

public class CartService {

    private final List<Cart> carts;

    public CartService(List<Cart> carts) {
        this.carts = carts;
    }

    public int getCartNumber() {
        return carts.size();
    }

    public long getGoodsNumberInCart(int id) {
        return getCartById(id).countItemsInCart();
    }

    public int getFirstCartIndex(String goods) {
        return getCartsByGoods(goods).get(0).getId();
    }

    public int getLastCartIndex(String goods) {
        List<Cart> cartsByGoods = getCartsByGoods(goods);
        return cartsByGoods.get(cartsByGoods.size() - 1).getId();
    }
    public int getCountOfCartsByGoods(String goods) {
        return getCartsByGoods(goods).size();
    }

    public String getCartContentInDetailsById(int id) {
        return getCartById(id).getCartContentInDetails();
    }

    public List<String> getTotalValues() {
        return carts.stream()
                .map(Cart::toString)
                .collect(Collectors.toList());
    }

    private List<Cart> getCartsByGoods(String goods) {
        return carts.stream()
                .filter(i -> i.contains(goods))
                .collect(Collectors.toList());
    }

    private Cart getCartById(int id) {
        return carts.stream()
                .filter(i -> i.getId()==id)
                .findAny()
                .get();
    }
}
