package pl.sdacademy.podstawy.homework3;

import java.math.BigDecimal;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        final Shop shop = new Shop(10);

        Product product1 = new Product("Czekolada Milka", BigDecimal.valueOf(3.20));
        Product product2 = new Product("Czekolada Goplana", BigDecimal.valueOf(2.20));
        Product product3 = new Product("Czekolada Wedel", BigDecimal.valueOf(3.00));
        Product product4 = new Product("Czekolada Terravita", BigDecimal.valueOf(1.90));

        Order order1 = shop.newOrder(product1, 3, "Wojciech");
        Order order2 = shop.newOrder(product1, 1, "Magda");
        Order order3 = shop.newOrder(product2, 3, "Tomasz");
        Order order4 = shop.newOrder(product3, 10, "Tomasz");
        Order order5 = shop.newOrder(product4, 2, "Arkadiusz");



        for (Order order : shop.getOrders()) {
            System.out.println(order.toString());
            System.out.println("Kwota za zamówienie: " + order.totalAmountOfOrder() + "\n");
        }

        System.out.println("Kwota za wszystkie zamówienia łącznie to " + shop.ordersValueInTotal() + "\n");


        System.out.println("\nWyszukaj klienta: ");
        Order[] ordersByClient = shop.searchByClient("Woj");
        System.out.println(Arrays.toString(ordersByClient));

        System.out.println("\nWyszukaj produkt: ");
        Order[] ordersByProduct = shop.searchByProduct("Wed");
        System.out.println(Arrays.toString(ordersByProduct));


    }
}
