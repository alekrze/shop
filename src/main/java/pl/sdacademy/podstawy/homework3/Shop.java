package pl.sdacademy.podstawy.homework3;

import java.math.BigDecimal;
import java.util.Arrays;

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

    public static Order newOrder(Product product, int quantity, String clientName) {
        Order order = new Order(product, quantity, clientName);
        return order;
    }

    public static BigDecimal ordersValueInTotal(Order[] orders) {
        BigDecimal ordersValueInTotal;
        ordersValueInTotal = BigDecimal.ZERO;
        BigDecimal sum;
        sum = BigDecimal.ZERO;

        for (Order order : orders) {
            ordersValueInTotal = sum.add(order.totalAmountOfOrder());
            sum = ordersValueInTotal;
        }

        return ordersValueInTotal;
    }

    public static Order[] searchByProduct(String string, Order[] orders) {
        Order[] searchByProduct = new Order[orders.length];
        int count = 0;

        for (Order order : orders) {
            if (order.getProduct().getName().contains(string)) {
                searchByProduct[count] = order;
                count++;
            }
        }
        searchByProduct = Arrays.copyOf(searchByProduct, count);

        return searchByProduct;
    }

    public static Order[] searchByClient(String string, Order[] orders) {
        Order[] searchByClient = new Order[orders.length];
        int count = 0;

        for (Order order : orders) {
            if (order.getClientName().contains(string)) {
                searchByClient[count] = order;
                count++;
            }
        }
        searchByClient = Arrays.copyOf(searchByClient, count);

        return searchByClient;
    }


    public static void main(String[] args) {
        final Order[] orders;

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

        System.out.println("Kwota za wszystkie zamówienia łącznie to " + ordersValueInTotal(orders) + "\n");


        System.out.println("\nWyszukaj klienta: ");
        Order[] ordersByClient = searchByClient("Woj", orders);
        System.out.println(Arrays.toString(ordersByClient));

        System.out.println("\nWyszukaj produkt: ");
        Order[] ordersByProduct = searchByProduct("Wed", orders);
        System.out.println(Arrays.toString(ordersByProduct));


    }


}
