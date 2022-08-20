package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Country;

public interface ICountryDao extends JpaRepository<Country, Long> {

}
