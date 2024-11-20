package com.comarch.szkolenia.car.rent.spring.controllers;

import com.comarch.szkolenia.car.rent.spring.services.ICarService;
import com.comarch.szkolenia.car.rent.spring.session.SessionObject;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommonController {

    private final ICarService carService;

    @Resource
    private SessionObject sessionObject;

    public CommonController(ICarService carService) {
        this.carService = carService;
    }

    @RequestMapping(path = {"/index", "/"}, method = RequestMethod.GET)
    public String menu(HttpSession httpSession) {
        if(httpSession.getAttribute("request") == null) {
            System.out.println("Pierwszy request !!!");
            httpSession.setAttribute("request", "Był !!");
        }
        System.out.println(this.sessionObject.getLoggedUser());
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
        //return "redirect:/index";
    }
}
