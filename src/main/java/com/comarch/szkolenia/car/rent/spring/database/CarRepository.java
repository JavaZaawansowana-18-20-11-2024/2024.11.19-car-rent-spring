package com.comarch.szkolenia.car.rent.spring.database;

import com.comarch.szkolenia.car.rent.spring.model.Car;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository implements CarRepositoryInterface {
    @Getter
    private final List<Car> cars = new ArrayList<>();

    CarRepository() {
        this.cars.add(new Car("BMW", "3", 300.0, 2020, "KR11"));
        this.cars.add(new Car("Toyota", "Corolla", 200.0, 2021, "KR22"));
        this.cars.add(new Car("Kia", "Ceed", 250.0, 2022, "KR33"));
        this.cars.add(new Car("Honda", "Civic", 150.0, 2018, "KR44"));
    }
}
