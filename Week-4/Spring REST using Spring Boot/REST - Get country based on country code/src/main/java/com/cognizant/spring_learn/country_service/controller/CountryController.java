package com.cognizant.spring_learn.country_service.controller;

import com.cognizant.spring_learn.country_service.model.Country;
import com.cognizant.spring_learn.country_service.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        return countryService.getCountry(code);
    }
}
