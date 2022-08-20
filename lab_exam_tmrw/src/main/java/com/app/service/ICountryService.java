package com.app.service;

import java.util.List;

import com.app.entities.Country;

public interface ICountryService {
	List<Country> getAllCountries();

	Country addCountryDetails(Country c, long id);

	void deleteCountry(long ctId);
	
	
}
