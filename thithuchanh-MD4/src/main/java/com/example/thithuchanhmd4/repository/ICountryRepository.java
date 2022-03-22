package com.example.thithuchanhmd4.repository;

import com.example.thithuchanhmd4.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICountryRepository extends PagingAndSortingRepository<Country, Long> {
}
