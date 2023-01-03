package com.robertolc.discounts;

import java.util.ArrayList;
import java.util.List;

/**
 * Descripción: Clase que calcula el total de precios que se van agregando a una lista
 * y aplica descuentos en porcentaje en caso de tener.
 */
public class PriceCalculator {
    private List<Double> prices = new ArrayList<>();
    private double discount = 0;

    public double getTotal() {

        double result = 0;
        for (Double price : prices) {
            result += price;
        }
        return result * ((100 - discount) / 100);
    }

    public void addPrice(double price) {
        prices.add(price);
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
