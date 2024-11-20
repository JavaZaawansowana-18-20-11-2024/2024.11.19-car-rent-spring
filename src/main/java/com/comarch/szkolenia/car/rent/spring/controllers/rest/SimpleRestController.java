package com.comarch.szkolenia.car.rent.spring.controllers.rest;

import com.comarch.szkolenia.car.rent.spring.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/rest/api")
public class SimpleRestController {

    @RequestMapping(path = "/test1/{surname}", method = RequestMethod.GET)
    public void test1(@RequestParam("name") String name,
                      @PathVariable("surname") String surname) {
        System.out.println(name);
        System.out.println(surname);
    }

    @RequestMapping(path = "/test2", method = RequestMethod.GET)
    public User test2() {
        User user = new User(1, "janusz", "janusz123");
        return user;
    }

    @RequestMapping(path = "/test3", method = RequestMethod.POST)
    public void test3(@RequestBody User user,
                      @RequestHeader("h1") String header) {
        System.out.println(user);
        System.out.println(header);
    }

    @RequestMapping(path = "/test4/{pesel}", method = RequestMethod.POST)
    public User test4(@RequestBody User user,
                      @RequestParam("flag") boolean flag,
                      @PathVariable("pesel") long pesel,
                      @RequestHeader(name = "header1", required = false) String header) {
        System.out.println(user);
        System.out.println(flag);
        System.out.println(pesel);
        System.out.println(header);

        user.setId(0);

        return user;
    }

    @RequestMapping(path = "/test5", method = RequestMethod.GET)
    public ResponseEntity<User> test5() {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .header("jakisheader", "value1")
                .header("jakisinnynaglowek", "value2")
                .body(new User(1, "admin", "admin"));
    }
}
