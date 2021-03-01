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
    private final Order[] orders;
    private int count = 0;

    public Shop(int capacity) {
        orders = new Order[capacity];
    }

    public Order newOrder(Product product, int quantity, String clientName) {
        if (count >= orders.length) {
            return null;
        }
        Order order = new Order(product, quantity, clientName);
        orders[count] = order;
        count++;
        return order;
    }

    public BigDecimal ordersValueInTotal() {
        BigDecimal ordersValueInTotal;
        ordersValueInTotal = BigDecimal.ZERO;
        BigDecimal sum;
        sum = BigDecimal.ZERO;

        for (int i = 0; i < count; i++) {
            ordersValueInTotal = sum.add(orders[i].totalAmountOfOrder());
            sum = ordersValueInTotal;
        }

        return ordersValueInTotal;
    }

    public Order[] searchByProduct(String string) {
        Order[] searchByProduct = new Order[orders.length];
        int resultsCount = 0;

        for (int i = 0; i < count; i++) {
            if (orders[i].getProduct().getName().contains(string)) {
                searchByProduct[resultsCount] = orders[i];
                resultsCount++;
            }
        }
        searchByProduct = Arrays.copyOf(searchByProduct, resultsCount);

        return searchByProduct;
    }

    public Order[] searchByClient(String string) {
        Order[] searchByClient = new Order[orders.length];
        int resultsCount = 0;

        for (int i = 0; i < count; i++) {
            if (orders[i].getClientName().contains(string)) {
                searchByClient[resultsCount] = orders[i];
                resultsCount++;
            }
        }
        searchByClient = Arrays.copyOf(searchByClient, resultsCount);

        return searchByClient;
    }

    public Order[] getOrders() {
        return Arrays.copyOf(orders, count);
    }
}
