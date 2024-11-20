package com.comarch.szkolenia.car.rent.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "tcar")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String model;
    private double price;
    private int year;
    private String plate;
    private boolean rent;

    public Car(int id,String brand, String model, double price, int year, String plate) {
        this(id, brand, model, price, year, plate,false);
    }
}
