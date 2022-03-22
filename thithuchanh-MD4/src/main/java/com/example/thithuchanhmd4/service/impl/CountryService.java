package com.example.thithuchanhmd4.service.impl;

import com.example.thithuchanhmd4.model.Country;
import com.example.thithuchanhmd4.repository.ICountryRepository;
import com.example.thithuchanhmd4.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService implements ICountryService {
    @Autowired
    ICountryRepository repository;
    @Override
    public Iterable<Country> findAll() {
        return repository.findAll();
    }
}
