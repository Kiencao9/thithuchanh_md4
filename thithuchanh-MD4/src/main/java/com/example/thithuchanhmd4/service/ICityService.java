package com.example.thithuchanhmd4.service;

import com.example.thithuchanhmd4.model.City;
import com.example.thithuchanhmd4.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface ICityService {
    Page<City> findAll(Pageable pageable);

    void save(City city);

    void delete(Long id);

    Optional<City> findById(Long id);

    Page<City> findByName(Pageable pageable, String name);

    Page<City>findAllByCountry(Pageable pageable, Country country);
}
