package com.example.thithuchanhmd4.service;

import com.example.thithuchanhmd4.model.Country;

import java.util.Optional;

public interface ICountryService {
    Iterable<Country> findAll();
    Optional<Country>findById(Long id);

}
