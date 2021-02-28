package pl.sdacademy.podstawy.homework3;

import java.math.BigDecimal;

public class Product {
    private final String name;
    private BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Nazwa produktu: " + name + " Cena: " + price;
    }
}
