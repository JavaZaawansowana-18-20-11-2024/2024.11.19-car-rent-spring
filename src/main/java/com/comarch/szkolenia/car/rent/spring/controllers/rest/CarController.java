package com.comarch.szkolenia.car.rent.spring.controllers.rest;

import com.comarch.szkolenia.car.rent.spring.model.Car;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/car")
public class CarController {

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Car getCar(@PathVariable("id") int id) {
        return null;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Car> getCars(@RequestParam(name = "color", required = false) String color,
                             @RequestParam(name = "brand", required = false) String brand) {
        return new ArrayList<>();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable("id") int id) {
        //???
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public Car add(@RequestBody Car car) {
        return car;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Car update(@RequestBody Car car, @PathVariable("id") int id) {
        car.setId(id);
        //service.updateCar(car);
        return car;
    }
}
