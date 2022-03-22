package com.example.thithuchanhmd4.service.impl;

import com.example.thithuchanhmd4.model.City;
import com.example.thithuchanhmd4.repository.ICityRepository;
import com.example.thithuchanhmd4.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService implements ICityService {
    @Autowired
    ICityRepository repository;

    @Override
    public Page<City> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void save(City city) {
        repository.save(city);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<City> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Page<City> findByName(Pageable pageable, String name) {
        return repository.findAllByNameContaining(pageable, name);
    }
}
