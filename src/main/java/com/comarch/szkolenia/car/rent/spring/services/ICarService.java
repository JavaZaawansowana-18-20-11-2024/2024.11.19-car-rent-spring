package com.comarch.szkolenia.car.rent.spring.services;

import com.comarch.szkolenia.car.rent.spring.model.Car;

import java.util.List;

public interface ICarService {
    boolean rentCar(String plate);
    List<Car> getCars();
}
