package com.example.thithuchanhmd4.repository;

import com.example.thithuchanhmd4.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICityRepository extends PagingAndSortingRepository<City, Long> {
    Page<City> findAllByNameContaining(Pageable pageable, String name);

}
