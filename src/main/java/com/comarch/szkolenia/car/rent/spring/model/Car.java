package com.comarch.szkolenia.car.rent.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {
    private String brand;
    private String model;
    private double price;
    private int year;
    private String plate;
    private boolean rent;

    public Car(String brand, String model, double price, int year, String plate) {
        this(brand, model, price, year, plate,false);
    }
}
