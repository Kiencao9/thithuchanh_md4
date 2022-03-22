package com.example.thithuchanhmd4.controller;

import com.example.thithuchanhmd4.model.City;
import com.example.thithuchanhmd4.model.Country;
import com.example.thithuchanhmd4.service.ICityService;
import com.example.thithuchanhmd4.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller

public class CityController {
    @Autowired
    private ICityService cityService;

    @Autowired
    private ICountryService countryService;

    @ModelAttribute(name = "cities")
    private Iterable<Country> findAll() {
        return countryService.findAll();
    }

    @GetMapping
    public ModelAndView showAll(@PageableDefault(value = 3) Pageable pageable,
                                @RequestParam Optional<String> search) {
        ModelAndView modelAndView = new ModelAndView("city/list");
        Page<City> cities;
        if (search.isPresent()) {
            cities = cityService.findByName(pageable, search.get());
            modelAndView.addObject("search", search.get());
        } else {
            cities = cityService.findAll(pageable);

        }
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView showDetail(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("city/detail");
        Optional<City> city = cityService.findById(id);
        city.ifPresent(value -> modelAndView.addObject("student", value));
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PageableDefault(value = 3) Pageable pageable, @PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("list");
        cityService.delete(id);
        Page<City> cities = cityService.findAll(pageable);
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("city/create");
        modelAndView.addObject("student", new City());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Optional<City> city) {
        city.ifPresent(s -> cityService.save(s));
        return "redirect:/city";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("city/edit");
        Optional<City> student = cityService.findById(id);
        student.ifPresent(value -> modelAndView.addObject("student", value));
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public String edit(@ModelAttribute Optional<City> city, @PathVariable Long id) {
        if (city.isPresent()) {
            City cityEdit = city.get();
            cityEdit.setId(id);
            cityService.save(cityEdit);
        }
        return "redirect:/city";
    }
}
