package com.cognizant.spring_learn.country_service.service;

import com.cognizant.spring_learn.country_service.model.Country;
import com.cognizant.spring_learn.country_service.model.CountryList;

import jakarta.annotation.PostConstruct;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class CountryService {

    private List<Country> countries;

    @PostConstruct
    public void init() {
        try {
            InputStream input = getClass().getClassLoader().getResourceAsStream("country.xml");

            JAXBContext context = JAXBContext.newInstance(CountryList.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            CountryList list = (CountryList) unmarshaller.unmarshal(input);
            countries = list.getCountryList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Country getCountry(String code) {
        return countries.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }
}