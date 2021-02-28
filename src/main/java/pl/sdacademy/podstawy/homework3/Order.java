package pl.sdacademy.podstawy.homework3;
/*
Klasa Order:
        * Produkt (jw), ilość, nazwa klienta, cena całkowita, data dodania
        (cena wyliczana na podstawie ilości i ceny produktu),
        * zaimplementować toString()
        ** dla chętnych: klasa reprezentująca pozycję zamówienia, wtedy może mieć wiele produktów
 */

import java.math.BigDecimal;
import java.time.LocalDate;

public class Order {
    private final Product product;
    private int quantity;
    private final String clientName;
    private LocalDate orderDate;

    public Order(Product product, int quantity, String clientName) {
        this.product = product;
        this.quantity = quantity;
        this.clientName = clientName;
        this.orderDate = LocalDate.now();
    }

    public BigDecimal totalAmountOfOrder() {
        BigDecimal price = product.getPrice();
        final BigDecimal totalAmountOfOrder = price.multiply(BigDecimal.valueOf(quantity));

        return totalAmountOfOrder;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getClientName() {
        return clientName;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    @Override
    public String toString() {
        return "ZAMÓWIENIE z dnia " + orderDate + "\n"
                + "Klient:" + clientName + "\n"
                + "Produkt: " + product.getName() + "\n"
                + "Ilość: " + quantity;
    }
}
