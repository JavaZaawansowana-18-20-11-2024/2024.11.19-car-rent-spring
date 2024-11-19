package com.comarch.szkolenia.car.rent.spring.services;

import com.comarch.szkolenia.car.rent.spring.database.CarRepositoryInterface;
import com.comarch.szkolenia.car.rent.spring.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements ICarService {

    private final CarRepositoryInterface carRepository;

    public CarService(CarRepositoryInterface carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public boolean rentCar(final String plate) {
        return this.carRepository.getCars().stream()
                .filter(car -> car.getPlate().equals(plate))
                .filter(car -> !car.isRent())
                .peek(car -> car.setRent(true))
                .findFirst()
                .isPresent();
    }

    @Override
    public List<Car> getCars() {
        //fix
        return this.carRepository.getCars();
    }
}
