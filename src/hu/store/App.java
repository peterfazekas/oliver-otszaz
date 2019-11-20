package hu.store;

import hu.store.contoller.CartService;
import hu.store.domain.service.Console;
import hu.store.domain.service.DataApi;
import hu.store.domain.service.DataParser;
import hu.store.domain.service.DataReader;

import java.util.Scanner;

public class App {

    private final CartService cartService;
    private final Console console;

    private App() {
        DataApi data = new DataApi(new DataReader(), new DataParser());
        cartService = new CartService(data.getData("penztar.txt"));
        console = new Console(new Scanner(System.in));
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("2. feladat:");
        System.out.println("A fizetések száma: " + cartService.getCartNumber());
        System.out.println("3. feladat:");
        System.out.println("Az első vásárló " + cartService.getGoodsNumberInCart(1) + " darab árucikket vásárolt.");
        System.out.println("4. feladat");
        System.out.print("Adja meg egy vásárlás sorszámát! ");
        int id = console.readInt();
        System.out.print("Adja meg egy árucikk nevét! ");
        String goods = console.read();
        System.out.print("Adja meg a vásárolt darabszámot! ");
        int count = console.readInt();
        System.out.println("5. feladat:");
        System.out.println("Az első vásárlás sorszáma: " + cartService.getFirstCartIndex(goods));
        System.out.println("Az utolsó vásárlás sorszáma: " + cartService.getLastCartIndex(goods));
        System.out.println(cartService.getCountOfCartsByGoods(goods) + " vásárlás során vettek belőle.");
    }
}
