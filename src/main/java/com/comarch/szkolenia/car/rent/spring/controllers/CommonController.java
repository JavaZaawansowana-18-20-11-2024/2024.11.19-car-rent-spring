package com.comarch.szkolenia.car.rent.spring.controllers;

import com.comarch.szkolenia.car.rent.spring.services.ICarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommonController {

    private final ICarService carService;

    public CommonController(ICarService carService) {
        this.carService = carService;
    }

    @RequestMapping(path = {"/index", "/"}, method = RequestMethod.GET)
    public String menu() {
        return "menu";
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("cars", this.carService.getCars());
        return "list";
    }

    @RequestMapping(path = "/rent", method = RequestMethod.GET)
    public String rent() {
        return "rent";
    }

    @RequestMapping(path = "/rent", method = RequestMethod.POST)
    public String rent(@RequestParam("plate") String plate, Model model) {
        model.addAttribute("result", this.carService.rentCar(plate));
        return "rent-result";
    }
}
