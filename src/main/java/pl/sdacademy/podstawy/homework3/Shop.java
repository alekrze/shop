package pl.sdacademy.podstawy.homework3;

import java.math.BigDecimal;

/*
Prosty sklep
Klasa Product:
* Nazwa i cena (BigDecimal)
* zaimplementować toString()

Klasa Order:
* Produkt (jw), ilość, nazwa klienta, cena całkowita, data dodania
(cena wyliczana na podstawie ilości i ceny produktu),
* zaimplementować toString()
** dla chętnych: klasa reprezentująca pozycję zamówienia, wtedy może mieć wiele produktów

Klasa Sklep:
* zawiera tablicę zamówień
* funkcja dodawania zamówienia (przyjmuje Product, ilość, nazwę klienta)
zwraca obiekt nowego zamówienia (nie przyjmie więcej zamówień niż zmieści się w tablicy)
* funkcja wyszukiwania zamówień według części nazwy klienta
zwraca tablicę zamówień
* funkcja wyszukiwania zamówień według części nazwy produktu
* funkcja zwracająca całkowitą wartość zamówień
 */
public class Shop {

    public static Order[] orders;

    public static Order newOrder(Product product, int quantity, String clientName) {
        Order order = new Order(product, quantity, clientName);
        return order;
    }

    public static BigDecimal ordersValueInTotal(Order[] orders) {
        BigDecimal ordersValueInTotal;
        ordersValueInTotal = BigDecimal.ZERO;
        BigDecimal sum = BigDecimal.ZERO;

        for (Order order : orders) {
            ordersValueInTotal = sum.add(order.totalAmountOfOrder()) ;
            sum = ordersValueInTotal;
        }

        return ordersValueInTotal;
    }

    public static void main(String[] args) {

        Product product1 = new Product("Czekolada Milka", BigDecimal.valueOf(3.20));
        Product product2 = new Product("Czekolada Goplana", BigDecimal.valueOf(2.20));
        Product product3 = new Product("Czekolada Wedel", BigDecimal.valueOf(3.00));
        Product product4 = new Product("Czekolada Terravita", BigDecimal.valueOf(1.90));

        Order order1 = newOrder(product1, 3, "Wojciech");
        Order order2 = newOrder(product1, 1, "Magda");
        Order order3 = newOrder(product2, 3, "Tomasz");
        Order order4 = newOrder(product3, 10, "Tomasz");
        Order order5 = newOrder(product4, 2, "Arkadiusz");

        orders = new Order[]{order1, order2, order3, order4, order5};

        for (Order order : orders) {
            System.out.println(order.toString());
            System.out.println("Kwota za zamówienie: " + order.totalAmountOfOrder() + "\n");
        }

        System.out.println("Kwota za wszystkie zamówienia łącznie to " + ordersValueInTotal(orders));


    }

}
