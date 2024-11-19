package com.comarch.szkolenia.car.rent.spring.database;

import com.comarch.szkolenia.car.rent.spring.model.Car;

import java.util.List;

public interface CarRepositoryInterface {
    List<Car> getCars();
}
