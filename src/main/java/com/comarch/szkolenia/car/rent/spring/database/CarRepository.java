package com.comarch.szkolenia.car.rent.spring.database;

import com.comarch.szkolenia.car.rent.spring.model.Car;
import com.comarch.szkolenia.car.rent.spring.services.IIdSequence;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class CarRepository implements CarRepositoryInterface {
    @Getter
    private final List<Car> cars = new ArrayList<>();
    private final IIdSequence idSequence;

    public CarRepository(IIdSequence idSequence) {
        this.idSequence = idSequence;
        System.out.println("CarRepository: " + System.identityHashCode(this.idSequence));
        this.cars.add(new Car(this.idSequence.getNextId(), "BMW", "3", 300.0, 2020, "KR11"));
        this.cars.add(new Car(this.idSequence.getNextId(), "Toyota", "Corolla", 200.0, 2021, "KR22"));
        this.cars.add(new Car(this.idSequence.getNextId(), "Kia", "Ceed", 250.0, 2022, "KR33"));
        this.cars.add(new Car(this.idSequence.getNextId(), "Honda", "Civic", 150.0, 2018, "KR44"));
    }
}
